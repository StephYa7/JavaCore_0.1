package JDK.Prac_01_Swing.ServerWindow;

public class Server implements ChatServerListener{
    boolean isServerWorking;
    private Listener listener;

    public Server(Listener listener) {
        this.listener = listener;
        this.isServerWorking = false;
    }

    public void start() {
        if (!isServerWorking) {
            isServerWorking = true;
            listener.messageRes("Статус сервера: " + isServerWorking);
        } else {
            listener.messageRes("Сервер запущен");
        }

    }

    public void stop() {
        if (isServerWorking) {
            isServerWorking = false;
            listener.messageRes("Статус сервера: " + isServerWorking);
        } else {
            listener.messageRes("Сервер не запущен");
        }

    }


    @Override
    public void ChatServerListener(boolean status) {

        if (status){
            stop();
        } else {
            start();
        }

    }
}