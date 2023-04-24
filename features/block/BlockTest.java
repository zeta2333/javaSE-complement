package usts.pycro.features.block;

import org.junit.Test;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-10 10:50 AM
 */
public class BlockTest {
    @Test
    public void test1() {
        String info = "<html>\n" +
                "                    <head>\n" +
                "                        <title>Title</title>\n" +
                "                    </head>\n" +
                "                    <body>\n" +
                "                        Hello,World!\n" +
                "                    </body>\n" +
                "                </html>";
        String info2 = """
                <html>
                    <head>
                        <title>Title</title>
                    </head>
                    <body>
                        Hello,World!
                    </body>
                </html>
                """;
        System.out.println("info = \n" + info);
        System.out.println("info2 = \n" + info2);
    }

    @Test
    public void test2() {
        String info = """
                <html>
                    <head>
                        <title>Title</title>
                    </head>
                    <body>
                        Hello,World!
                    </body>
                </html>
                """;
    }

    @Test
    /**
     * JDK14新特性：
     * \：取消换行操作
     * \s：表示一个空格
     */
    public void test3(){
        String sql = """
                select id, name, email \
                from customers \\\\
                where id > 4 \
                order by email desc
                """;
        System.out.println("sql = \n" + sql);
    }
}
