package codes.egirl.annunicate;

import codes.egirl.annunicate.listener.AnnunicateListener;
import lombok.Getter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;

public class Annunicate {

    @Getter private final JDA jda;

    public Annunicate() throws LoginException {
        this.jda = JDABuilder.createDefault("annunicate token")
                .setStatus(OnlineStatus.OFFLINE)
                .setEnabledIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.GUILD_EMOJIS)
                .setMemberCachePolicy(MemberCachePolicy.ALL)
                .build();

        this.jda.addEventListener(new AnnunicateListener());
    }

    public static void main(String[] args) {
        try {
            new Annunicate();
        } catch (LoginException exception) {
            exception.printStackTrace();
        }
    }
}
