package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Robot: Park A5 blue allience v1", group = "Robot")
public class test extends LinearOpMode {
    Robot robot = new Robot();

    public void runOpMode() {
        robot.init(hardwareMap);
        waitForStart();
        robot.driveForward(20, 1);
    }
}


