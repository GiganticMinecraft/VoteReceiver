package click.seichi

import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.Bukkit
import org.bukkit.event.Listener
import org.bukkit.event.EventHandler
import com.vexsoftware.votifier.model.VotifierEvent

class VoteReceiver extends JavaPlugin with Listener {

  override def onEnable(): Unit = {
    Bukkit.getServer.getPluginManager.registerEvents(this, this)
  }

  override def onDisable(): Unit = super.onDisable()

  @EventHandler
  def onVotifierEvent(e: VotifierEvent): Unit = {
    val vote = e.getVote

    val voteUserName = vote.getUsername

    Bukkit.dispatchCommand(getServer.getConsoleSender, s"vote record $voteUserName")
  }

}
