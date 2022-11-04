import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.File;

public class ThreadDownloader extends Thread {
    private int threadNum;
    private UrlManager manager;

    public ThreadDownloader(int threadNum, UrlManager manager) {
        this.threadNum = threadNum;
        this.manager = manager;
    }

    @Override
    public void run() {
        while (!manager.isAllDownloaded()) {
            int filenum = manager.getKey();
            System.out.println("Thread-" + this.threadNum + " started to download file: " + filenum);

            URL url;
            try {
                url = new URL (manager.getValue(filenum));

                String[] strings = manager.getValue(filenum).split("/");
                File file = new File(strings[strings.length - 1]);

                try (InputStream in = url.openStream();
                        BufferedInputStream bis = new BufferedInputStream(in);
                        FileOutputStream fos = new FileOutputStream(file)) {
        
                    byte[] data = new byte[1024];
                    int count;
                    while ((count = bis.read(data, 0, 1024)) != -1) {
                        fos.write(data, 0, count);
                    }
                }
                catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            }
            
            System.out.println("Thread" + this.threadNum + " finished to download file: " + filenum);
    }
    }
}