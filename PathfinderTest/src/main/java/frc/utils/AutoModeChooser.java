package frc.utils;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.auto.paths.DoNothing;
import frc.utils.GameData.Side;

public class AutoModeChooser {
    /**
     * Class to choose correct autonomous submode given target balance (switch/scale) and game data
     */
    private GameData
        data;
    
    private String
        balance;
    
    public AutoModeChooser(String targetBalance) {
        data = Robot.gameData;
        balance = new String(targetBalance);
    }

    public CommandGroup choose() {
        if(balance.toUpperCase().equals("SWITCH")) {
            if(data.myStartSide == Side.CENTER) {
                if(data.mySwitch == Side.LEFT) {
                    // Center Start Left Switch
                }
                else if(data.mySwitch == Side.RIGHT) {
                    // Center Start Right Switch
                }
                else {
                    // Do Nothing
                }
            }
            else {
                // Baseline, if switch auto is enabled from left/right start
            }
        }
        else if(balance.toUpperCase().equals("SCALE")) {
            if(data.myStartSide == data.myScale) {
                if(data.myStartSide == Side.LEFT) {
                    // Left Start Left Scale
                }
                else if(data.myStartSide == Side.RIGHT) {
                    // Right Start Right Scale
                }
                else {
                    // Do Nothing
                }
            }
            else {
                if(data.myScale == Side.LEFT) {
                    // Right Start Left Scale
                }
                else if(data.myScale == Side.RIGHT) {
                    // Left Start Right Scale
                }
                else {
                    // Do Nothing
                }
            }
        }
        else {
            // Do Nothing
        }
        
        return new DoNothing();
    }
}