package test;

import dao.CurseDao;
import dto.Curse;

public class TestCurse {
    public static void main(String[] args) {

        CurseDao dao = new CurseDao();

        Curse curse = new Curse(
            0,
            2,
            "testUser",
            "/WebContent/css/images/loginbutton.png"
        );

        boolean result = dao.insert(curse);

        System.out.println(result);
    }
}