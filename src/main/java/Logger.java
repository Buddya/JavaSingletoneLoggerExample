import java.text.SimpleDateFormat;

public class Logger {
    protected int num = 1;
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    private static Logger logger; //храним ссылку

    private Logger() {} //скрываем конструктор

    //возвращаем один и тот же объект логгер при запросе
    public static Logger getInstance() {
        if (logger == null) logger = new Logger();
        return logger;
    }

    public void log(String msg) {
        System.out.println("[" + simpleDateFormat.format(System.currentTimeMillis()) + " " + num++ + "] " + msg);
    }
}