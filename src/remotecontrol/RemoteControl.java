package remotecontrol;

import command.Command;

public class RemoteControl {
  private Command command;

  public void setCommand(Command command) {
    this.command = command;
  }

  public void execute() {
    command.execute();
  }
}
