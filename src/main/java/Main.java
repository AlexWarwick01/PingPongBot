import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {

    public static void main(String[] args) throws LoginException{
    JDABuilder builder = new JDABuilder(AccountType.BOT);
    //tokenStore.token should be changed to your own bots token - do not push this to Github though.
    builder.setToken(tokenStore.Token());
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
        //Broken
        if(event.getMessage().getContentRaw().contains("What is my name??")){
            event.getChannel().sendMessage("Your name is " +  event.getAuthor());
        }
//      Will ignore messages from other bots so it doesnt break
        if(event.getAuthor().isBot()){
            return;
        }
    }
}
