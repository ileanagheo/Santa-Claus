package myclasses;

import common.Constants;
import enums.Category;
import enums.Cities;
import enums.CityStrategyEnum;

import java.util.ArrayList;
import java.util.Comparator;
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
     * @return
     */
    public static Implementare getInstance() {
        if (instance == null) {
            instance = new Implementare();
        }
        return instance;
    }

    /**
     * @param list
     * @return
     */
    public List<Category> deepCPref(final List<Category> list) {
        List<Category> newList = new ArrayList<>();
        for (Category o : list) {
            newList.add(o);
        }
        return newList;
    }

    /**
     * @param list
     * @return
     */
    public List<Double> deepCHistory(final List<Double> list) {
        List<Double> newList = new ArrayList<>();
        for (Double o : list) {
            newList.add(o);
        }
        return newList;
    }

    /**
     * @param list
     * @return
     */
    public List<Cadou> deepCCadou(final List<Cadou> list) {
        List<Cadou> newList = new ArrayList<>();
        for (Cadou o : list) {
            newList.add(o);
        }
        return newList;
    }

    /**
     * @param input
     * @return
     */
    public AnnualChildren start(final Input input) {
        AnnualChildren aC = new AnnualChildren();
        List<ChildrenOneYear> listCOY = new ArrayList<>();
        List<Copil> copii = input.getInitialData().getChildren(), eligibil = new ArrayList<>();
        List<Cadou> cadouri = input.getInitialData().getSantaGiftsList();
        double averageScoreSum = 0, santaBudget = input.getSantaBudget(), budgetUnit = 0;
        copii.sort(Copil::compareTo);
        for (int i = 0; i < copii.size(); i++) {
            if (copii.get(i).getAge() < Constants.BABY) {
                copii.get(i).setAverageScore(Constants.SCORELESS);
                copii.get(i).getNiceScoreHistory().add(copii.get(i).getNiceScore());
            } else if (copii.get(i).getAge() < Constants.KID) {
                copii.get(i).setAverageScore(copii.get(i).getNiceScore());
                copii.get(i).setAverageScore(copii.get(i).getAverageScore()
                        + copii.get(i).getAverageScore() * copii.get(i).getNiceScoreBonus()
                        / Constants.HUNDRED);
                if (copii.get(i).getAverageScore() > Constants.SCORELESS) {
                    copii.get(i).setAverageScore(Constants.SCORELESS);
                }
                copii.get(i).getNiceScoreHistory().add(copii.get(i).getNiceScore());
            } else if (copii.get(i).getAge() <= Constants.TEEN) {
                copii.get(i).setAverageScore(copii.get(i).getNiceScore());
                    copii.get(i).setAverageScore(copii.get(i).getAverageScore() + copii.get(i)
                            .getAverageScore() * copii.get(i).getNiceScoreBonus()
                            / Constants.HUNDRED);
                if (copii.get(i).getAverageScore() > Constants.SCORELESS) {
                    copii.get(i).setAverageScore(Constants.SCORELESS);
                }
                copii.get(i).getNiceScoreHistory().add(copii.get(i).getNiceScore());
            }
            averageScoreSum += copii.get(i).getAverageScore();
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
        for (int i = 0; i < eligibil.size(); i++) {
            eligibil.get(i).setAssignedBudget(eligibil.get(i).getAverageScore() * budgetUnit);
            if (eligibil.get(i).getElf().equals(BLACK)) {
                eligibil.get(i).setAssignedBudget(eligibil.get(i).getAssignedBudget() - eligibil
                        .get(i).getAssignedBudget() * Constants.THIRTY / Constants.HUNDRED);
            }
            if (eligibil.get(i).getElf().equals(PINK)) {
                eligibil.get(i).setAssignedBudget(eligibil.get(i).getAssignedBudget() + eligibil
                        .get(i).getAssignedBudget() * Constants.THIRTY / Constants.HUNDRED);
            }
        }
        cadouri.sort(Cadou::compareTo);
        for (int i = 0; i < eligibil.size(); i++) {
            double aux = eligibil.get(i).getAssignedBudget();
            for (int j = 0; j < eligibil.get(i).getGiftsPreferences().size(); j++) {
                for (int k = 0; k < cadouri.size(); k++) {
                    if (eligibil.get(i).getGiftsPreferences().get(j) == cadouri.get(k)
                            .getCategory()) {
                        if (cadouri.get(k).getPrice() < eligibil.get(i).getAssignedBudget()
                                && cadouri.get(k).getQuantity() > 0) {
                            eligibil.get(i).getReceivedGifts().add(cadouri.get(k));
                            eligibil.get(i).setAssignedBudget(eligibil.get(i).getAssignedBudget()
                                    - cadouri.get(k).getPrice());
                            cadouri.get(k).setQuantity(cadouri.get(k).getQuantity() - 1);
                            break;
                        }
                    }
                }
            }
            eligibil.get(i).setAssignedBudget(aux);
        }
        for (Copil copil : eligibil) {
            if (copil.getReceivedGifts().size() == 0 && copil.getElf().equals(YELLOW)) {
                Category pref = copil.getGiftsPreferences().get(0);
                for (Cadou cadou : cadouri) {
                    if (pref.equals(cadou.getCategory())) {
                        if (cadou.getQuantity() > 0) {
                            copil.getReceivedGifts().add(cadou);
                            cadou.setQuantity(cadou.getQuantity() - 1);
                            break;
                        }
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
            for (int i = 0; i < eligibil.size(); i++) {
                eligibil.get(i).setAge(eligibil.get(i).getAge() + 1);
            }
            for (int i = 0; i < copii.size(); i++) {
                if (copii.get(i).getAge() < Constants.BABY) {
                    copii.get(i).getNiceScoreHistory().add(copii.get(i).getNiceScore());
                    eligibil.add(copii.get(i));
                } else if (copii.get(i).getAge() < Constants.KID) {
                    copii.get(i).getNiceScoreHistory().add(copii.get(i).getNiceScore());
                    eligibil.add(copii.get(i));
                } else if (copii.get(i).getAge() <= Constants.TEEN) {
                    copii.get(i).getNiceScoreHistory().add(copii.get(i).getNiceScore());
                    eligibil.add(copii.get(i));
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
                        List<Category> giftPref = new ArrayList<>();
                        for (Category o : faraDuplicate) {
                            giftPref.add(o);
                        }
                        c.setGiftsPreferences(giftPref);
                        c.setElf(upC.getElf());
                    }
                }
            }
            eligibil.sort(Copil::compareTo);
            for (int i = 0; i < eligibil.size(); i++) {
                if (eligibil.get(i).getAge() < Constants.BABY) {
                    eligibil.get(i).setAverageScore(Constants.SCORELESS);
                } else if (eligibil.get(i).getAge() < Constants.KID) {
                    double sum = 0.0;
                    for (double score : eligibil.get(i).getNiceScoreHistory()) {
                        sum = sum + score;
                    }
                    sum = sum / eligibil.get(i).getNiceScoreHistory().size();
                    eligibil.get(i).setAverageScore(sum);
                    eligibil.get(i).setAverageScore(eligibil.get(i).getAverageScore()
                            + eligibil.get(i).getAverageScore() * eligibil.get(i)
                            .getNiceScoreBonus() / Constants.HUNDRED);
                    if (eligibil.get(i).getAverageScore() > Constants.SCORELESS) {
                        eligibil.get(i).setAverageScore(Constants.SCORELESS);
                    }
                } else if (eligibil.get(i).getAge() <= Constants.TEEN) {
                    double index = 1;
                    double sum = 0.0;
                    for (double d : eligibil.get(i).getNiceScoreHistory()) {
                        sum += (index * d);
                        index++;
                    }
                    index--;
                    sum = sum / (index * (index + 1) / 2);
                    eligibil.get(i).setAverageScore(sum);
                    eligibil.get(i).setAverageScore(eligibil.get(i).getAverageScore()
                            + eligibil.get(i).getAverageScore() * eligibil.get(i)
                            .getNiceScoreBonus() / Constants.HUNDRED);
                    if (eligibil.get(i).getAverageScore() > Constants.SCORELESS) {
                        eligibil.get(i).setAverageScore(Constants.SCORELESS);
                    }
                }
                averageScoreSum = averageScoreSum + eligibil.get(i).getAverageScore();
            }
            budgetUnit = santaBudget / averageScoreSum;
            for (int i = 0; i < eligibil.size(); i++) {
                eligibil.get(i).setAssignedBudget(eligibil.get(i).getAverageScore() * budgetUnit);
                if (eligibil.get(i).getElf().equals(BLACK)) {
                    eligibil.get(i).setAssignedBudget(eligibil.get(i).getAssignedBudget() - eligibil
                            .get(i).getAssignedBudget() * Constants.THIRTY / Constants.HUNDRED);
                }
                if (eligibil.get(i).getElf().equals(PINK)) {
                    eligibil.get(i).setAssignedBudget(eligibil.get(i).getAssignedBudget() + eligibil
                            .get(i).getAssignedBudget() * Constants.THIRTY / Constants.HUNDRED);
                }
            }
            input.getInitialData().getSantaGiftsList().sort(Cadou::compareTo);
            eligibil.sort(Copil::compareTo);
            if (annualChange.getStrategy().equals(CityStrategyEnum.NICE_SCORE)) {
                eligibil.sort(new Comparator<Copil>() {
                    @Override
                    public int compare(final Copil o1, final Copil o2) {
                        return Double.compare(o2.getAverageScore(), o1.getAverageScore());
                    }
                });
            } else if (annualChange.getStrategy().equals(CityStrategyEnum.NICE_SCORE_CITY)) {
                for (Cities city : Cities.values()) {
                    double sum = 0.0;
                    int index = 0;
                    for (Copil copil : eligibil) {
                        if (copil.getCity().equals(city)) {
                            sum += copil.getAverageScore();
                            index ++;
                        }
                    }
                    sum /= index;
                    for (Copil copil : eligibil) {
                        if (copil.getCity().equals(city)) {
                            copil.setniceScoreCity(sum);
                        }
                    }
                }
                eligibil.sort(new Comparator<Copil>() {
                    @Override
                    public int compare(final Copil o1, final Copil o2) {
                        return Double.compare(o2.getniceScoreCity(), o1.getniceScoreCity());
                    }
                });
            }
            for (int i = 0; i < eligibil.size(); i++) {
                List<Cadou> cadouriCopil = new ArrayList<>();
                double aux = eligibil.get(i).getAssignedBudget();
                for (int j = 0; j < eligibil.get(i).getGiftsPreferences().size(); j++) {
                    for (int k = 0; k < input.getInitialData().getSantaGiftsList().size(); k++) {
                        if (eligibil.get(i).getGiftsPreferences().get(j) == input.
                                getInitialData().getSantaGiftsList().get(k).getCategory()) {
                            if (input.getInitialData().getSantaGiftsList().get(k).getPrice()
                                    <= eligibil.get(i).getAssignedBudget() && input.getInitialData()
                                    .getSantaGiftsList().get(k).getQuantity() > 0) {
                                cadouriCopil.add(input.getInitialData().getSantaGiftsList().get(k));
                                eligibil.get(i).setAssignedBudget(eligibil.get(i).
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
                eligibil.get(i).setAssignedBudget(aux);
                eligibil.get(i).setReceivedGifts(cadouriCopil);
            }
            for (Copil copil : eligibil) {
                if (copil.getReceivedGifts().size() == 0 && copil.getElf().equals(YELLOW)) {
                    Category pref = copil.getGiftsPreferences().get(0);
                    for (Cadou cadou : input.getInitialData().getSantaGiftsList()) {
                        if (pref.equals(cadou.getCategory())) {
                            if (cadou.getQuantity() > 0) {
                                copil.getReceivedGifts().add(cadou);
                                cadou.setQuantity(cadou.getQuantity() - 1);
                                break;
                            }
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
}
