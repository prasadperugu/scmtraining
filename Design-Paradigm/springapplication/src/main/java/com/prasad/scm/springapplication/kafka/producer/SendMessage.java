import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Logger;

public class SendMessage {

	private Socket socket;
	private BufferedReader input;

	private final Logger logger = Logger.getLogger(SendMessage.class.getName());

	private String host;
	private int port;

	public SendMessage(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void sendMessageToTopic() throws UnknownHostException, IOException {
		try {
			logger.info("Connecting to socket...");
			socket = new Socket(host, port);
			logger.info("Connected to socket");

			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line = "";
			while (!line.equals("Over")) {
				try {
					line = input.readLine();
					logger.info("Received message: %s", line);
					producer.sendMessage(line);
				} catch (IOException e) {
					logger.error("Error reading message: %s", e);
				}
			}
		} catch (Exception e) {
			logger.error("Error: %s", e);
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					logger.error("Error closing socket: %s", e);
				}
			}
		}
	}
}