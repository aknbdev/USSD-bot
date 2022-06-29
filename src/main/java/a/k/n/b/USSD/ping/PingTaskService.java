/*
package a.k.n.b.USSD.ping;

public class PingTaskService {

    @Value("${pingtask.url}")
    private String url;

    @Scheduled(fixedRateString = "${pingtask.period}")
    public void keepAlive() {
        try {
            URL url = new URL(getUrl());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            connection.disconnect();
            log.info("Ping {}, OK: response code {}", url.getHost(), connection.getResponseCode());
        } catch (IOException e) {
            log.error("Ping FAILED");
        }
    }
}*/
