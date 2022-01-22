package myclasses;

import common.Constants;
import enums.Category;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Implementare {
    /**
     * @param list
     * @return
     */
    public final List<Category> deepCPref(final List<Category> list) {
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
    public final List<Double> deepCHistory(final List<Double> list) {
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
    public final List<Cadou> deepCCadou(final List<Cadou> list) {
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
    public final AnnualChildren start(final Input input) {
        AnnualChildren aC = new AnnualChildren();
        List<ChildrenOneYear> listCOY = new ArrayList<>();
        List<Copil> copii = input.getInitialData().getChildren(), eligibil = new ArrayList<>();
        List<Cadou> cadouri = input.getInitialData().getSantaGiftsList();
        double averageScoreSum = 0, santaBudget = input.getSantaBudget(), budgetUnit = 0;
        copii.sort(Copil::compareTo);
        for (int i = 0; i < copii.size(); i++) {
            if (copii.get(i).getAge() < Constants.BABY) { copii.get(i).
                    setAverageScore(Constants.SCORELESS);
                copii.get(i).getNiceScoreHistory().add(copii.get(i).getNiceScore());
                eligibil.add(copii.get(i));
            } else if (copii.get(i).getAge() < Constants.KID) {
                copii.get(i).setAverageScore(copii.get(i).getNiceScore());
                copii.get(i).getNiceScoreHistory().add(copii.get(i).getNiceScore());
                eligibil.add(copii.get(i));
            } else if (copii.get(i).getAge() <= Constants.TEEN) {
                copii.get(i).setAverageScore(copii.get(i).getNiceScore());
                copii.get(i).getNiceScoreHistory().add(copii.get(i).getNiceScore());
                eligibil.add(copii.get(i));
            }
            averageScoreSum += copii.get(i).getAverageScore();
        } budgetUnit = santaBudget / averageScoreSum;
        for (int i = 0; i < copii.size(); i++) {
            copii.get(i).setAssignedBudget(copii.get(i).getAverageScore() * budgetUnit);
        } cadouri.sort(Cadou::compareTo);
        for (int i = 0; i < copii.size(); i++) {
            double aux = copii.get(i).getAssignedBudget();
            for (int j = 0; j < copii.get(i).getGiftsPreferences().size(); j++) {
                for (int k = 0; k < cadouri.size(); k++) {
                    if (copii.get(i).getGiftsPreferences().get(j) == cadouri.get(k).getCategory()) {
                        if (cadouri.get(k).getPrice() < copii.get(i).getAssignedBudget()) {
                            copii.get(i).getReceivedGifts().add(cadouri.get(k));
                            copii.get(i).setAssignedBudget(copii.get(i).getAssignedBudget()
                                    - cadouri.get(k).getPrice());
                            break;
                        }
                    }
                }
            } copii.get(i).setAssignedBudget(aux);
        }
        List<ChildOut> cO = new ArrayList<>();
        for (Copil copil : eligibil) {
            ChildOut o = new ChildOut(copil.getId(), copil.getLastName(), copil.getFirstName(),
                    copil.getCity(), copil.getAge(), deepCPref(copil.getGiftsPreferences()),
                    copil.getAverageScore(), deepCHistory(copil.getNiceScoreHistory()),
                    copil.getAssignedBudget(), deepCCadou(copil.getReceivedGifts()));
            cO.add(o);
        } ChildrenOneYear cOY = new ChildrenOneYear(cO);
        listCOY.add(cOY);
        for (int ani = 0; ani < input.getNumberOfYears(); ani++) {
            AnnualChange annualChange = input.getAnnualChanges().get(ani);
            averageScoreSum = 0;
            santaBudget = annualChange.getNewSantaBudget();
            input.setSantaBudget(santaBudget);
            copii = annualChange.getNewChildren();
            for (int i = 0; i < eligibil.size(); i++) {
                eligibil.get(i).setAge(eligibil.get(i).getAge() + 1);
            } for (int i = 0; i < copii.size(); i++) {
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
            } eligibil.removeIf(ch -> ch.getAge() > Constants.TEEN);
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
                        } c.setGiftsPreferences(giftPref);
                    }
                }
            } eligibil.sort(Copil::compareTo);
            for (int i = 0; i < eligibil.size(); i++) {
                if (eligibil.get(i).getAge() < Constants.BABY) {
                    eligibil.get(i).setAverageScore(Constants.SCORELESS);
                } else if (eligibil.get(i).getAge() < Constants.KID) {
                    double sum = 0.0;
                    for (double score : eligibil.get(i).getNiceScoreHistory()) {
                        sum = sum + score;
                    } sum = sum / eligibil.get(i).getNiceScoreHistory().size();
                    eligibil.get(i).setAverageScore(sum);
                } else if (eligibil.get(i).getAge() <= Constants.TEEN) {
                    double index = 1;
                    double sum = 0.0;
                    for (double d : eligibil.get(i).getNiceScoreHistory()) {
                        sum += (index * d);
                        index++;
                    } index--;
                    sum = sum / (index * (index + 1) / 2);
                    eligibil.get(i).setAverageScore(sum);
                }
                averageScoreSum = averageScoreSum + eligibil.get(i).getAverageScore();
            } budgetUnit = santaBudget / averageScoreSum;
            for (int i = 0; i < eligibil.size(); i++) {
                eligibil.get(i).setAssignedBudget(eligibil.get(i).getAverageScore() * budgetUnit);
            } input.getInitialData().getSantaGiftsList().sort(Cadou::compareTo);
            for (int i = 0; i < eligibil.size(); i++) {
                List<Cadou> cadouriCopil = new ArrayList<>();
                double aux = eligibil.get(i).getAssignedBudget();
                for (int j = 0; j < eligibil.get(i).getGiftsPreferences().size(); j++) {
                    for (int k = 0; k < input.getInitialData().getSantaGiftsList().size(); k++) {
                        if (eligibil.get(i).getGiftsPreferences().get(j) == input.
                                getInitialData().getSantaGiftsList().get(k).getCategory()) {
                            if (input.getInitialData().getSantaGiftsList().get(k).getPrice()
                                    <= eligibil.get(i).getAssignedBudget()) {
                                cadouriCopil.add(input.getInitialData().getSantaGiftsList().get(k));
                                eligibil.get(i).setAssignedBudget(eligibil.get(i).
                                        getAssignedBudget() - input.getInitialData().
                                        getSantaGiftsList().get(k).getPrice());
                                break;
                            }
                        }
                    }
                } eligibil.get(i).setAssignedBudget(aux);
                eligibil.get(i).setReceivedGifts(cadouriCopil);
            } List<ChildOut> chOut = new ArrayList<>();
            ChildrenOneYear chOneYear = new ChildrenOneYear(cO);
            for (Copil copil : eligibil) {
                ChildOut o = new ChildOut(copil.getId(), copil.getLastName(), copil.getFirstName(),
                        copil.getCity(), copil.getAge(), deepCPref(copil.getGiftsPreferences()),
                        copil.getAverageScore(), deepCHistory(copil.getNiceScoreHistory()),
                        copil.getAssignedBudget(), deepCCadou(copil.getReceivedGifts()));
                chOut.add(o);
            } chOneYear.setChildren(chOut);
            listCOY.add(chOneYear);
        } aC.setAnnualChildren(listCOY);
        return aC;
    }
}
