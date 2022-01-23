package myclasses;

import common.Constants;
import enums.Category;
import enums.Cities;
import enums.CityStrategyEnum;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static enums.ElvesType.BLACK;
import static enums.ElvesType.PINK;
import static enums.ElvesType.YELLOW;

public final class Implementare {
    private static Implementare instance = null;

    /**
     *
     */
    private Implementare() {
    }

    /**
     * @return instance
     */
    public static Implementare getInstance() {
        if (instance == null) {
            instance = new Implementare();
        }
        return instance;
    }

    /**
     * @param list for deep copying preferences
     * @return list
     */
    public List<Category> deepCPref(final List<Category> list) {
        return new ArrayList<>(list);
    }

    /**
     * @param list for deep copying history of niceness
     * @return list
     */
    public List<Double> deepCHistory(final List<Double> list) {
        return new ArrayList<>(list);
    }

    /**
     * @param list for deep copying gifts
     * @return list
     */
    public List<Cadou> deepCCadou(final List<Cadou> list) {
        return new ArrayList<>(list);
    }

    /**
     * @param input that is read from json files
     * @return list of children and their received gifts for each year
     */
    public AnnualChildren start(final Input input) {
        AnnualChildren aC = new AnnualChildren();
        List<ChildrenOneYear> listCOY = new ArrayList<>();
        List<Copil> copii = input.getInitialData().getChildren(), eligibil = new ArrayList<>();
        List<Cadou> cadouri = input.getInitialData().getSantaGiftsList();
        double averageScoreSum = 0, santaBudget = input.getSantaBudget(), budgetUnit;
        copii.sort(Copil::compareTo);
        for (Copil copil : copii) {
            if (copil.getAge() < Constants.BABY) {
                copil.setAverageScore(Constants.SCORELESS);
                copil.getNiceScoreHistory().add(copil.getNiceScore());
            } else if (copil.getAge() < Constants.KID) {
                avgScore(copil);
            } else if (copil.getAge() <= Constants.TEEN) {
                avgScore(copil);
            }
            averageScoreSum += copil.getAverageScore();
        }
        budgetUnit = santaBudget / averageScoreSum;
        for (Copil c : copii) {
            Copil copil = new Copil.CopilBuilder(c.getId(), c.getNiceScore(),
                    c.getGiftsPreferences(), c.getElf(), c.getCity(), c.getLastName(),
                    c.getFirstName(), c.getAge(), c.getNiceScoreHistory(), c.getAverageScore(),
                    c.getAssignedBudget(), c.getReceivedGifts(), c.getniceScoreCity())
                    .bonusScore(c.getNiceScoreBonus()).build();
            eligibil.add(copil);
        }
        eligibil.removeIf(ch -> ch.getAge() > Constants.TEEN);
        elfColors(eligibil, budgetUnit);
        cadouri.sort(Cadou::compareTo);
        for (Copil copil : eligibil) {
            double aux = copil.getAssignedBudget();
            for (int j = 0; j < copil.getGiftsPreferences().size(); j++) {
                for (Cadou cadou : cadouri) {
                    if (copil.getGiftsPreferences().get(j) == cadou
                            .getCategory()) {
                        if (cadou.getPrice() < copil.getAssignedBudget()
                                && cadou.getQuantity() > 0) {
                            copil.getReceivedGifts().add(cadou);
                            copil.setAssignedBudget(copil.getAssignedBudget()
                                    - cadou.getPrice());
                            cadou.setQuantity(cadou.getQuantity() - 1);
                            break;
                        }
                    }
                }
            }
            copil.setAssignedBudget(aux);
        }
        for (Copil copil : eligibil) {
            if (copil.getReceivedGifts().size() == 0 && copil.getElf().equals(YELLOW)) {
                Category pref = copil.getGiftsPreferences().get(0);
                for (Cadou cadou : cadouri) {
                    if (pref.equals(cadou.getCategory())) {
                        if (cadou.getQuantity() > 0) {
                            copil.getReceivedGifts().add(cadou);
                            cadou.setQuantity(cadou.getQuantity() - 1);
                        }
                        break;
                    }
                }
            }
        }
        List<ChildOut> cO = new ArrayList<>();
        List<GiftOut> gfOut;
        for (Copil copil : eligibil) {
            gfOut = new ArrayList<>();
            for (Cadou gift : copil.getReceivedGifts()) {
                GiftOut gf = new GiftOut(gift.getProductName(), gift.getPrice(),
                        gift.getCategory());
                gfOut.add(gf);
            }
            ChildOut o = new ChildOut(copil.getId(), copil.getLastName(), copil.getFirstName(),
                    copil.getCity(), copil.getAge(), deepCPref(copil.getGiftsPreferences()),
                    copil.getAverageScore(), deepCHistory(copil.getNiceScoreHistory()),
                    copil.getAssignedBudget(), gfOut);
            cO.add(o);
        }
        ChildrenOneYear cOY = new ChildrenOneYear(cO);
        listCOY.add(cOY);
        for (int ani = 0; ani < input.getNumberOfYears(); ani++) {
            AnnualChange annualChange = input.getAnnualChanges().get(ani);
            averageScoreSum = 0;
            santaBudget = annualChange.getNewSantaBudget();
            input.setSantaBudget(santaBudget);
            copii = annualChange.getNewChildren();
            for (Copil copil : eligibil) {
                copil.setAge(copil.getAge() + 1);
            }
            for (Copil copil : copii) {
                if (copil.getAge() < Constants.BABY) {
                    copil.getNiceScoreHistory().add(copil.getNiceScore());
                    eligibil.add(copil);
                } else if (copil.getAge() < Constants.KID) {
                    copil.getNiceScoreHistory().add(copil.getNiceScore());
                    eligibil.add(copil);
                } else if (copil.getAge() <= Constants.TEEN) {
                    copil.getNiceScoreHistory().add(copil.getNiceScore());
                    eligibil.add(copil);
                }
            }
            eligibil.removeIf(ch -> ch.getAge() > Constants.TEEN);
            cadouri = annualChange.getNewGifts();
            input.getInitialData().getSantaGiftsList().addAll(cadouri);
            for (ChildUpdate upC : annualChange.getChildrenUpdates()) {
                for (Copil c : eligibil) {
                    if (upC.getId() == c.getId()) {
                        if (upC.getNiceScore() != null) {
                            c.getNiceScoreHistory().add(upC.getNiceScore());
                        }
                        List<Category> old = new ArrayList<>(c.getGiftsPreferences());
                        c.setGiftsPreferences(upC.getGiftsPreferences());
                        for (Category o : old) {
                            if (!c.getGiftsPreferences().contains(o)) {
                                c.getGiftsPreferences().add(o);
                            }
                        }
                        Set<Category> faraDuplicate = new LinkedHashSet<>(c.getGiftsPreferences());
                        List<Category> giftPref = new ArrayList<>(faraDuplicate);
                        c.setGiftsPreferences(giftPref);
                        c.setElf(upC.getElf());
                    }
                }
            }
            eligibil.sort(Copil::compareTo);
            for (Copil copil : eligibil) {
                if (copil.getAge() < Constants.BABY) {
                    copil.setAverageScore(Constants.SCORELESS);
                } else if (copil.getAge() < Constants.KID) {
                    double sum = 0.0;
                    for (double score : copil.getNiceScoreHistory()) {
                        sum = sum + score;
                    }
                    sum = sum / copil.getNiceScoreHistory().size();
                    copil.setAverageScore(sum);
                    copil.setAverageScore(copil.getAverageScore()
                            + copil.getAverageScore() * copil
                            .getNiceScoreBonus() / Constants.HUNDRED);
                    if (copil.getAverageScore() > Constants.SCORELESS) {
                        copil.setAverageScore(Constants.SCORELESS);
                    }
                } else if (copil.getAge() <= Constants.TEEN) {
                    double index = 1;
                    double sum = 0.0;
                    for (double d : copil.getNiceScoreHistory()) {
                        sum += (index * d);
                        index++;
                    }
                    index--;
                    sum = sum / (index * (index + 1) / 2);
                    copil.setAverageScore(sum);
                    copil.setAverageScore(copil.getAverageScore()
                            + copil.getAverageScore() * copil
                            .getNiceScoreBonus() / Constants.HUNDRED);
                    if (copil.getAverageScore() > Constants.SCORELESS) {
                        copil.setAverageScore(Constants.SCORELESS);
                    }
                }
                averageScoreSum = averageScoreSum + copil.getAverageScore();
            }
            budgetUnit = santaBudget / averageScoreSum;
            elfColors(eligibil, budgetUnit);
            input.getInitialData().getSantaGiftsList().sort(Cadou::compareTo);
            eligibil.sort(Copil::compareTo);
            if (annualChange.getStrategy().equals(CityStrategyEnum.NICE_SCORE)) {
                eligibil.sort((o1, o2) -> Double.compare(o2.getAverageScore(), o1.getAverageScore()));
            } else if (annualChange.getStrategy().equals(CityStrategyEnum.NICE_SCORE_CITY)) {
                for (Cities city : Cities.values()) {
                    double sum = 0.0;
                    int index = 0;
                    for (Copil copil : eligibil) {
                        if (city.equals(copil.getCity())) {
                            sum += copil.getAverageScore();
                            index++;
                        }
                    }
                    sum /= index;
                    for (Copil copil : eligibil) {
                        if (city.equals(copil.getCity())) {
                            copil.setniceScoreCity(sum);
                        }
                    }
                }
                eligibil.sort((c1, c2) -> {
                    if (c2.getniceScoreCity() != c1.getniceScoreCity()) {
                        return Double.compare(c2.getniceScoreCity(), c1.getniceScoreCity());
                    } else {
                        return CharSequence.compare(c1.getCity().toString(),
                                c2.getCity().toString());
                    }
                });
            }

            for (Copil copil : eligibil) {
                List<Cadou> cadouriCopil = new ArrayList<>();
                double aux = copil.getAssignedBudget();
                for (int j = 0; j < copil.getGiftsPreferences().size(); j++) {
                    for (int k = 0; k < input.getInitialData().getSantaGiftsList().size(); k++) {
                        if (copil.getGiftsPreferences().get(j) == input.
                                getInitialData().getSantaGiftsList().get(k).getCategory()) {
                            if (input.getInitialData().getSantaGiftsList().get(k).getPrice()
                                    <= copil.getAssignedBudget() && input.getInitialData()
                                    .getSantaGiftsList().get(k).getQuantity() > 0) {
                                cadouriCopil.add(input.getInitialData().getSantaGiftsList().get(k));
                                copil.setAssignedBudget(copil.
                                        getAssignedBudget() - input.getInitialData().
                                        getSantaGiftsList().get(k).getPrice());
                                input.getInitialData().getSantaGiftsList().get(k).setQuantity(input
                                        .getInitialData().getSantaGiftsList().get(k).getQuantity()
                                        - 1);
                                break;
                            }
                        }
                    }
                }
                copil.setAssignedBudget(aux);
                copil.setReceivedGifts(cadouriCopil);
            }
            for (Copil copil : eligibil) {
                if (copil.getReceivedGifts().size() == 0 && copil.getElf().equals(YELLOW)) {
                    Category pref = copil.getGiftsPreferences().get(0);
                    for (Cadou cadou : input.getInitialData().getSantaGiftsList()) {
                        if (pref.equals(cadou.getCategory())) {
                            if (cadou.getQuantity() > 0) {
                                copil.getReceivedGifts().add(cadou);
                                cadou.setQuantity(cadou.getQuantity() - 1);
                            }
                            break;
                        }
                    }
                }
            }
            eligibil.sort(Copil::compareTo);
            List<ChildOut> chOut = new ArrayList<>();
            ChildrenOneYear chOneYear = new ChildrenOneYear(cO);
            for (Copil copil : eligibil) {
                gfOut = new ArrayList<>();
                for (Cadou gift : deepCCadou(copil.getReceivedGifts())) {
                    GiftOut gf = new GiftOut(gift.getProductName(), gift.getPrice(),
                            gift.getCategory());
                    gfOut.add(gf);
                }
                ChildOut c = new ChildOut(copil.getId(), copil.getLastName(), copil.getFirstName(),
                        copil.getCity(), copil.getAge(), deepCPref(copil.getGiftsPreferences()),
                        copil.getAverageScore(), deepCHistory(copil.getNiceScoreHistory()),
                        copil.getAssignedBudget(), gfOut);
                chOut.add(c);
            }
            chOneYear.setChildren(chOut);
            listCOY.add(chOneYear);
        }
        aC.setAnnualChildren(listCOY);
        return aC;
    }

    private void elfColors(final List<Copil> eligibil, final double budgetUnit) {
        for (Copil copil : eligibil) {
            copil.setAssignedBudget(copil.getAverageScore() * budgetUnit);
            if (copil.getElf().equals(BLACK)) {
                copil.setAssignedBudget(copil.getAssignedBudget() - copil.getAssignedBudget()
                        * Constants.THIRTY / Constants.HUNDRED);
            }
            if (copil.getElf().equals(PINK)) {
                copil.setAssignedBudget(copil.getAssignedBudget() + copil.getAssignedBudget()
                        * Constants.THIRTY / Constants.HUNDRED);
            }
        }
    }

    private void avgScore(final Copil copil) {
        copil.setAverageScore(copil.getNiceScore());
        copil.setAverageScore(copil.getAverageScore() + copil.getAverageScore()
                * copil.getNiceScoreBonus() / Constants.HUNDRED);
        if (copil.getAverageScore() > Constants.SCORELESS) {
            copil.setAverageScore(Constants.SCORELESS);
        }
        copil.getNiceScoreHistory().add(copil.getNiceScore());
    }
}
