package com.path;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author zk
 * @Description: 获取java项目的根目录-方法大全
 * @date 2018-09-28 15:17
 */
public class Demo {
    public static void main(String[] args) {

        //一 相对路径的获得
        //说明:相对路径(即不写明时候到底相对谁)均可通过以下方式获得（不论是一般的java项目还是web项目）
        String relativelyPath=System.getProperty("user.dir");
        System.out.println(relativelyPath);

        //上述相对路径中，java项目中的文件是相对于项目的根目录
        //web项目中的文件路径视不同的web服务器不同而不同（tomcat是相对于 tomcat安装目录\bin）


        //二 类加载目录的获得(即当运行时某一类时获得其装载目录)
        //1.1)通用的方法一(不论是一般的java项目还是web项目,先定位到能看到包路径的第一级目录)
        Demo.class.getClassLoader().getResourceAsStream("test.txt");

        //(test.txt文件的路径为 项目名\src\test.txt;类TestAction所在包的第一级目录位于src目录下)

        //1.2)通用方法二 (此方法和1.1中的方法类似,不同的是此方法必须以'/'开头,参考http://riddickbryant.iteye.com/blog/436693) 
        InputStream is=Demo.class.getResourceAsStream("/test.txt");
        //(test.txt文件的路径为 项目名\src\test.txt,类Test1所在包的第一级目录位于src目录下)



        /*三 web项目根目录的获得(发布之后)
                1 从servlet出发

                可建立一个servlet在其的init方法中写入如下语句
        ServletContext s1=this.getServletContext();
        String temp=s1.getRealPath("/"); (关键) 
        结果形如：D:\工具\Tomcat-6.0\webapps\002_ext\ (002_ext为项目名字)

        如果是调用了s1.getRealPath("")则输出D:\工具\Tomcat-6.0\webapps\002_ext(少了一个"\")

                2 从httpServletRequest出发

                String cp11111=request.getSession().getServletContext().getRealPath("/");
        /结果形如:D:\工具\Tomcat-6.0\webapps\002_ext\

        */


        /**
         * 四 classpath的获取(在Eclipse中为获得src或者classes目录的路径)

         方法一 Thread.currentThread().getContextClassLoader().getResource("").getPath()

         eg: String t=Thread.currentThread().getContextClassLoader().getResource("").getPath();
         System.out.println("t---"+t);

         输出:t---/E:/order/002_ext/WebRoot/WEB-INF/classes/


         方法二 JdomParse.class.getClassLoader().getResource("").getPath() (JdomParse为src某一个包中的类,下同)

         eg:String p1=JdomParse.class.getClassLoader().getResource("").getPath();
         System.out.println("JdomParse.class.getClassLoader().getResource--"+p1);

         输出: JdomParse.class.getClassLoader().getResource--/E:/order/002_ext/WebRoot/WEB-INF/classes/

          

         另外,如果想把文件放在某一包中,则可以 通过以下方式获得到文件(先定位到该包的最后一级目录)

         eg String p2=JdomParse.class.getResource("").getPath(); 
         System.out.println("JdomParse.class.getResource---"+p2);

         输出: JdomParse.class.getResource---/E:/order/002_ext/WebRoot/WEB-INF/classes/jdom/ (JdomParse为src目录下jdom包中的类)

         */



    }
	
	
	public void showURL() throws IOException {
		
		// 第一种：获取类加载的根路径   D:\git\daotie\daotie\target\classes
		File f = new File(this.getClass().getResource("/").getPath());
		System.out.println(f);

		// 获取当前类的所在工程路径; 如果不加“/”  获取当前类的加载目录  D:\git\daotie\daotie\target\classes\my
		File f2 = new File(this.getClass().getResource("").getPath());
		System.out.println(f2);

		// 第二种：获取项目路径    D:\git\daotie\daotie
		File directory = new File("");// 参数为空
		String courseFile = directory.getCanonicalPath();
		System.out.println(courseFile);
		

		// 第三种：  file:/D:/git/daotie/daotie/target/classes/
		URL xmlpath = this.getClass().getClassLoader().getResource("");
		System.out.println(xmlpath);
	

		// 第四种： D:\git\daotie\daotie
		System.out.println(System.getProperty("user.dir"));
		
		/*
		 * 结果： C:\Documents and Settings\Administrator\workspace\projectName
		 * 获取当前工程路径
		 */
		// 第五种：  获取所有的类路径 包括jar包的路径
		System.out.println(System.getProperty("java.class.path"));
		
	}
	
	
	
	
	
	
	
	
}
