package frc.robot.rigo;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/*
* Class to simplify the use of the limelight
* */
public class RigoVision {


    private static NetworkTable visionTable;


    //Data
    private static NetworkTableEntry targetCount;
    private static NetworkTableEntry horizontalOffset;
    private static NetworkTableEntry verticalOffset;
    private static NetworkTableEntry targetArea;
    private static NetworkTableEntry rotationTarget;

    //Settings
    private static NetworkTableEntry ledMode;
    private static NetworkTableEntry camMode;
    private static NetworkTableEntry pipeline;
    private static NetworkTableEntry streamMode;

    //


    public RigoVision() {
        //Dont call constructor twice
        if(visionTable != null){
            System.out.println("No need to instantiate Rigo Vision again");
            return;
        }

        //Set up key entries and table

        visionTable = NetworkTableInstance.getDefault().getTable("limelight");
        targetCount = visionTable.getEntry("tv");
        horizontalOffset = visionTable.getEntry("key");
        verticalOffset = visionTable.getEntry("key");
        targetArea = visionTable.getEntry("key");
        rotationTarget = visionTable.getEntry("key");


        ledMode = visionTable.getEntry("key");
        camMode = visionTable.getEntry("key");
        pipeline = visionTable.getEntry("key");
        streamMode = visionTable.getEntry("key");

    }


    public static int getTargetCount(){
        return (int) targetCount.getDouble(0);
    }

}
