package test;


import java.util.List;

import dao.HistoryDao;
import dto.History;



public class HistoryDaoTest {



    public static void main(String[] args) {
    	System.out.println("テスト開始");

        try {


            // DAOを作成
            HistoryDao dao =
                new HistoryDao();



            // テストするproject_id
            int project_id = 1;




            // DAOから加工履歴取得
            List<History> list =
                dao.getHistory(project_id);




            // 取得件数表示
            System.out.println(
                "取得件数：" + list.size()
            );




            // 取得したデータを確認
            for(History h : list) {


                System.out.println(
                    "画像URL："
                    + h.getEditedimage_url()
                );


                System.out.println(
                    "キャプション："
                    + h.getCaption()
                );


                System.out.println(
                    "加工順："
                    + h.getProcess_count()
                );


                System.out.println(
                    "-------------"
                );

            }



        }
        catch(Exception e) {


            e.printStackTrace();


        }


    }

}