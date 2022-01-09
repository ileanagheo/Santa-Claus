package myclasses;

import java.util.ArrayList;
import java.util.List;

public class Implementare {
    public AnnualChildren incep(Input input) {
        AnnualChildren aC = new AnnualChildren();
        List<ChildrenOneYear> listCOY = new ArrayList<>();

        List<Copil> copii = input.getInitialData().getChildren();
        List<Cadou> cadouri = input.getInitialData().getSantaGiftsList();
        List<Copil> eligibil = new ArrayList<>();
        double averageScoreSum = 0;
        double santaBudget = input.getSantaBudget();
        double budgetUnit = 0;
        //Runda 0

        //Sortez lista de copii dupa id-uri pentru a avea calculele corecte.
        copii.sort(Copil::compareTo);

        for (int i = 0; i < copii.size(); i++) {
            //Gasesc categoria de varsta a copiluluil si setez ce trebuie.
            //Daca copilul e Baby.
            if (copii.get(i).getAge() < 5) {
                copii.get(i).setAverageScore(10.0);
                eligibil.add(copii.get(i));
            }
            //Daca copilul e Kid.
            else if (copii.get(i).getAge() < 12) {
                copii.get(i).setAverageScore(copii.get(i).getNiceScore());
                    copii.get(i).getNiceScoreHistory().add(copii.get(i).getNiceScore());
                eligibil.add(copii.get(i));
            }
            //Daca copilul e Teen.
            else if (copii.get(i).getAge() < 18) {
                copii.get(i).setAverageScore(copii.get(i).getNiceScore());
                    copii.get(i).getNiceScoreHistory().add(copii.get(i).getNiceScore());
                eligibil.add(copii.get(i));
            }
            //Daca copilul e Young Adult, il exclud din output.

            //Calculez suma scorurilor average de la toti copiii.
            averageScoreSum += copii.get(i).getAverageScore();
        }

        //Calculez bugetul unitar.
        budgetUnit = santaBudget / averageScoreSum;

        //Calculez bugetul alocat fiecarui copil.
        for (int i = 0; i < copii.size(); i++) {
            copii.get(i).setAssignedBudget(copii.get(i).getAverageScore() * budgetUnit);
        }

        //Urmeaza distribuirea cadourilor.
        //Sortez cadourile dupa pret.
        cadouri.sort(Cadou::compareTo);

        for (int i = 0; i < copii.size(); i++) {
            double aux = copii.get(i).getAssignedBudget();
            for (int j = 0; j < copii.get(i).getGiftsPreferences().size(); j++) {
                    for (int k = 0; k < cadouri.size(); k++) {
                        if (copii.get(i).getGiftsPreferences().get(j) == cadouri.get(k).getCategory())
                            if (cadouri.get(k).getPrice() < copii.get(i).getAssignedBudget()) {
                                copii.get(i).getReceivedGifts().add(cadouri.get(k));
                                copii.get(i).setAssignedBudget(copii.get(i).getAssignedBudget() - cadouri.get(k).getPrice());
                            }
                    }
            }
            copii.get(i).setAssignedBudget(aux);
        }

        List<ChildOut> cO = new ArrayList<>();
        for(Copil copil:copii){
            ChildOut o = new ChildOut(copil.getId(), copil.getLastName(), copil.getFirstName(),
                    copil.getCity(), copil.getAge(), copil.getGiftsPreferences(), copil.getAverageScore(),
                    copil.getNiceScoreHistory(), copil.getAssignedBudget(), copil.getReceivedGifts());
            cO.add(o);
        }
        ChildrenOneYear cOY = new ChildrenOneYear(cO);
        listCOY.add(cOY);

        //de la runda 1 in sus.
        for (int ani = 0; ani < input.getNumberOfYears(); ani++) {
            AnnualChange annualChange = input.getAnnualChanges().get(ani);
            //Reinitializez variabilele urmatoare:
            averageScoreSum = 0;
            budgetUnit = 0;
            santaBudget = annualChange.getNewSantaBudget();
            copii = annualChange.getNewChildren();
            cadouri = annualChange.getNewGifts();

            //Sortez lista de copii dupa id-uri pentru a avea calculele corecte.
            copii.sort(Copil::compareTo);

            //Incrementez varsta copiilor.
            for (int i = 0; i < copii.size(); i++) {
                copii.get(i).setAge(copii.get(i).getAge() + 1);
            }

            for (int i = 0; i < copii.size(); i++) {
                //Gasesc categoria de varsta a copiluluil si setez ce trebuie.
                //Daca copilul e Baby.
                if (copii.get(i).getAge() < 5) {
                    copii.get(i).setAverageScore(10.0);
                    eligibil.add(copii.get(i));
                }
                //Daca copilul e Kid.
                else if (copii.get(i).getAge() < 12) {
                    copii.get(i).setAverageScore(copii.get(i).getNiceScore());
                    copii.get(i).getNiceScoreHistory().add(copii.get(i).getNiceScore());
                    eligibil.add(copii.get(i));
                }
                //Daca copilul e Teen.
                else if (copii.get(i).getAge() < 18) {
                    copii.get(i).setAverageScore(copii.get(i).getNiceScore());
                    copii.get(i).getNiceScoreHistory().add(copii.get(i).getNiceScore());
                    eligibil.add(copii.get(i));
                }
                //Daca copilul e Young Adult, il exclud din output.

                //Calculez suma scorurilor average de la toti copiii.
                averageScoreSum = averageScoreSum + copii.get(i).getAverageScore();
            }

            //Calculez bugetul unitar.
            budgetUnit = santaBudget / averageScoreSum;

            //Calculez bugetul alocat fiecarui copil.
            for (int i = 0; i < copii.size(); i++) {
                copii.get(i).setAssignedBudget(copii.get(i).getAverageScore() * budgetUnit);
            }

            //Urmeaza distribuirea cadourilor.
            //Sortez cadourile dupa pret.
            cadouri.sort(Cadou::compareTo);

            for (int i = 0; i < copii.size(); i++) {
                double aux = copii.get(i).getAssignedBudget();
                for (int j = 0; j < copii.get(i).getGiftsPreferences().size(); j++) {
                    for (int k = 0; k < cadouri.size(); k++) {
                        if (copii.get(i).getGiftsPreferences().get(j) == cadouri.get(k).getCategory())
                            if (cadouri.get(k).getPrice() < copii.get(i).getAssignedBudget()) {
                                copii.get(i).getReceivedGifts().add(cadouri.get(k));
                                copii.get(i).setAssignedBudget(copii.get(i).getAssignedBudget() - cadouri.get(k).getPrice());
                            }
                    }
                }
                copii.get(i).setAssignedBudget(aux);
            }

            for(Copil copil:copii){
                ChildOut o = new ChildOut(copil.getId(), copil.getLastName(), copil.getFirstName(),
                        copil.getCity(), copil.getAge(), copil.getGiftsPreferences(), copil.getAverageScore(),
                        copil.getNiceScoreHistory(), copil.getAssignedBudget(), copil.getReceivedGifts());
                cO.add(o);
            }
            listCOY.add(cOY);
        }
        aC.setAnnualChildren(listCOY);
        return aC;
    }
}
