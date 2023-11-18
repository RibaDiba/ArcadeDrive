// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
    private CANSparkMax leftMotor1 = new CANSparkMax(0, MotorType.kBrushless);
    private CANSparkMax leftMotor2 = new CANSparkMax(1, MotorType.kBrushless);
    private CANSparkMax rightMotor1 = new CANSparkMax(2, MotorType.kBrushless);
    private CANSparkMax rightMotor2 = new CANSparkMax(3, MotorType.kBrushless);

    private Joystick joystick1 = new Joystick(0);

    double startTime;


  @Override
  public void robotInit() {}

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {
    startTime = Timer.getFPGATimestamp();
  }

  @Override
  public void autonomousPeriodic() {
    double time = Timer.getFPGATimestamp();

    if (time - startTime <= 10) {
      leftMotor1.set(.5);
      leftMotor2.set(.5);
      rightMotor1.set(-.5);
      rightMotor2.set(-.5);
    }
    else if (time - startTime > 10 && time - startTime <= 12){
      leftMotor1.set(0);
      leftMotor2.set(0);
      rightMotor1.set(-.5);
      rightMotor2.set(-.5);
    }
    else { 
      leftMotor1.set(0);
      leftMotor2.set(0);
      rightMotor1.set(0);
      rightMotor2.set(0);
    }

  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {

    double motorSpeed = -joystick1.getRawAxis(0);
    double motorTurn = joystick1.getRawAxis(4);

    double leftPower = motorSpeed + motorTurn;
    double rightPower = motorSpeed - motorTurn;

    leftMotor1.set(leftPower);
    leftMotor2.set(leftPower);
    rightMotor1.set(rightPower);
    rightMotor2.set(rightPower);
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
