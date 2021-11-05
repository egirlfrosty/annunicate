package codes.egirl.annunicate.listener;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdateNicknameEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class AnnunicateListener extends ListenerAdapter {

    @Override
    public void onGuildMemberUpdateNickname(GuildMemberUpdateNicknameEvent event) {
        final Member annunicate = event.getMember();

        if (annunicate.getIdLong() == 229735457716568065L) {
            annunicate.modifyNickname("annunicate").queue();
            System.out.println("annunicate tried to change his nickname but I stopped him :D");
        }
    }
}
