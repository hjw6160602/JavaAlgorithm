/**
 * TimeTool.java
 * Created by SaiDiCaprio on 2020/6/1.
 * Copyright © 2020 SaiDiCaprio. All rights reserved.
 */

package 工具类;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTool {
    private  static final SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss.SSS");

    public interface Task {
        void  execute();
    }

    public  static  void check(String title, Task task) {
        if (task == null) {
            return;
        }
        title = (title == null) ? "" : ("[" + title + "]");
        System.out.println(title);

        System.out.println("开始: " + fmt.format(new Date()));

        long begin = System.currentTimeMillis();
        task.execute();
        long end = System.currentTimeMillis();

        double delta = (end - begin) / 1000.0;
        System.out.println("耗时: " + delta + "秒");
        System.out.println("--------------------------------------------");
    }
}
