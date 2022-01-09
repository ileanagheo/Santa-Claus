package myclasses;

import java.util.ArrayList;
import java.util.List;

public class Implementare {
    public AnnualChildren incep(Input input) {
        AnnualChildren aC = new AnnualChildren();
        List<ChildrenOneYear> listCOY = new ArrayList<>();

        List<Copil> copii = input.getInitialData().getChildren();
        List<Cadou> cadouri = input.getInitialData().getSantaGiftsList();
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
                copii.get(i).getNiceScoreHistory().add(10.0);
            }
            //Daca copilul e Kid.
            else if (copii.get(i).getAge() < 12) {
                copii.get(i).setAverageScore(copii.get(i).getNiceScore());
                copii.get(i).getNiceScoreHistory().add(copii.get(i).getNiceScore());
            }
            //Daca copilul e Teen.
            else if (copii.get(i).getAge() < 18) {
                copii.get(i).setAverageScore(copii.get(i).getNiceScore());
                copii.get(i).getNiceScoreHistory().add(copii.get(i).getNiceScore());
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


        //de la runda 1 in sus.

    }
}
