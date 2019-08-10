/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Vision extends Subsystem {
  // private static Vision instance = new Vision();

  // public static Vision getInstance() {
  //   return instance;
  // }

  NetworkTableEntry xEntry1;
  NetworkTableEntry yEntry1;
  NetworkTableEntry xEntry2;
  NetworkTableEntry yEntry2;
  NetworkTableEntry size1;
  NetworkTableEntry size2;
  NetworkTableInstance inst;
  NetworkTable table;
    
  public Vision() {
    inst = NetworkTableInstance.getDefault();
    table = inst.getTable("RRTFollowing");
    xEntry1 = table.getEntry("centerX1");
    yEntry1 = table .getEntry("centerY1");
    size1 = table.getEntry("size1");
    xEntry2 = table.getEntry("centerX2");
    yEntry2 = table.getEntry("centerY2");
    size2 = table.getEntry("size2");
  }
  
  public double getLeftTapeSize() {
    return size1.getDouble(0);
  }

  public double getRightTapeSize() {
    return size2.getDouble(0);
  }

  public double getLeftTapeX() {
    return xEntry1.getDouble(-1000);
  }

  public double getLeftTapeY() {
    return yEntry1.getDouble(-1000);
  }

  public double getRightTapeX() {
    return xEntry2.getDouble(-1000);
  }

  public double getRightTapeY() {
    return yEntry2.getDouble(-1000);
  }

  public double getCenterX() {
    return (xEntry2.getDouble(-1000) + xEntry1.getDouble(-1000))/ 2;
  }

  @Override
  public void initDefaultCommand() {
  }
}
