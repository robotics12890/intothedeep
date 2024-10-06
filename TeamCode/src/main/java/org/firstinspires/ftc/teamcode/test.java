package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Autonomous(name = "test encoder V9" , group = "Robot")
public class test extends LinearOpMode {
    Robot robot = new Robot();

    public void runOpMode() {
        robot.init(hardwareMap);
        telemetry.addData("Encoder", "%7d:%7d:%7d:%7d",
                robot.leftFrontDrive.getCurrentPosition(),
                robot.rightFrontDrive.getCurrentPosition(),
                robot.leftBackDrive.getCurrentPosition(),
                robot.rightBackDrive.getCurrentPosition());
        telemetry.update();

        waitForStart();
        robot.driveForward(10, 1);
         telemetry.addData("Encoder", "%7d:%7d:%7d:%7d",
                 robot.leftFrontDrive.getCurrentPosition(),
                 robot.rightFrontDrive.getCurrentPosition(),
                 robot.leftBackDrive.getCurrentPosition(),
                 robot.rightBackDrive.getCurrentPosition());
        telemetry.update();
        sleep(999999999);
    }
}
