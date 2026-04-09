package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

public class TankDriveTrain implements DriveTrain {

    private Robot robot;
    public TankDriveTrain(Robot r) {
        robot = r;
    }

    @Override
    public void controllerUpdate(Gamepad gp) {

    }
}
