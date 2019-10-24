import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {

    public static void main(String[] args) throws LoginException{
    JDABuilder builder = new JDABuilder(AccountType.BOT);
    String token = "NjM2OTAxNzIwNDgzNDMwNDAw.XbGXDA.8qIbO8AxNn5AKCBOsqvu52vIq0c";
    builder.setToken(token);
    builder.addEventListeners(new Main());
    builder.build();
    }
    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        System.out.println("We recieved a message from " +
                event.getAuthor().getName() + ": " +
                event.getMessage().getContentDisplay()
        );
//      Will respond Pong to when !ping is ran
        if(event.getMessage().getContentRaw().contains("ping")){
            event.getChannel().sendMessage("Pong!").queue();
        }
//      Will ignore messages from other bots so it doesnt break
        if(event.getAuthor().isBot()){
            return;
        }
    }
}
