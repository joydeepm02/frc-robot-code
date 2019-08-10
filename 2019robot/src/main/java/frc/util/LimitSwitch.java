/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.util;

import edu.wpi.first.wpilibj.DigitalInput;

/**
 * Limit Switch Class that Extends WPILib's Digitalinput Class
 */
public class LimitSwitch extends DigitalInput{
    /**
    * @param channel the DIO channel for the digital input 0-9 are on-board, 10-25 are on the MXP
    */
    
    public LimitSwitch (int channel)
    {
        super(channel);
    }

    /**
     * @return Returns true if the limit switch is pressed.
     */

    public boolean getPressed()
    {
        return get();
    }
}
