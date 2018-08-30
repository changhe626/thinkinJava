package thread.example.demo2;

public class LoginService {

    private static String usernameRef;
    private static String passwordRef;

     public static  synchronized void doPost(String username,String password){
        usernameRef=username;
        if("a".equals(username)){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        passwordRef=password;
        System.out.println("username="+username+",password="+password);
    }
}


class ALogin extends  Thread{
    @Override
    public void run() {
        LoginService.doPost("a","aa");
    }
}


class BLogin extends  Thread{
    @Override
    public void run() {
        LoginService.doPost("b","bb");
    }
}


class Test{
    public static void main(String[] args) {
        ALogin aLogin = new ALogin();
        aLogin.start();
        BLogin bLogin = new BLogin();
        bLogin.start();
        //username=b,password=bb
        //username=a,password=aa

        //在doPost上synchronized 会顺序执行的
        //username=a,password=aa
        //username=b,password=bb

    }
}

