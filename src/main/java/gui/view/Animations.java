package gui.view;

import exceptions.MovingExcpetion;
import gameboard.objects.MovingObject;
import javafx.animation.AnimationTimer;

import java.util.concurrent.TimeUnit;

/**
 * This class implements the animations for sowing and harvesting the fields.
 */

public class Animations {
    int column;
    int row;


    public void harvest(){

    }

    public void sow(){

    }

    private void moveToFieldBeginning(MovingObject movingObject, Matchfield matchfield, int field) {
        while (column > 20) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            moveToFieldBeginningColumn(movingObject, matchfield, field);

        }
        while (row > 14) {
            try {
                TimeUnit.SECONDS.sleep(1);
                moveToFieldBeginningRow(movingObject, matchfield, field);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }


    public void cultivate(MovingObject movingObject, Matchfield matchfield, int column, int row, int field){
        this.column = column;
        this.row = row;
        moveToFieldBeginning(movingObject, matchfield, field);
    }

    private void moveToFieldBeginningColumn(MovingObject movingObject, Matchfield matchfield, int field) {
        if (field == 1) {
                try {
                    if (matchfield.getMovingObjectImageView().getRotate() != 90) {
                        matchfield.getMovingObjectImageView().setRotate(90);
                    }
                    movingObject.moveLeft();
                } catch (MovingExcpetion e) {
                    e.printStackTrace();
                }
                column--;
                matchfield.setTileOfObject(column, row);
        }
    }

    private void moveToFieldBeginningRow(MovingObject movingObject, Matchfield matchfield, int field) {
        if (field == 1) {
                try {
                    if (matchfield.getMovingObjectImageView().getRotate() != 180) {
                        matchfield.getMovingObjectImageView().setRotate(180);
                    }
                    movingObject.moveUp();
                } catch (MovingExcpetion e) {
                    e.printStackTrace();
                }
                row--;
                matchfield.setTileOfObject(column, row);
        }

    }

    private void cultivateField(MovingObject movingObject, Matchfield matchfield, int field){
        if (field == 1) {
            if (column < 29) {
                try {
                    if (matchfield.getMovingObjectImageView().getRotate() != 270) {
                        matchfield.getMovingObjectImageView().setRotate(270);
                    }
                    movingObject.moveRight();
                } catch (MovingExcpetion e) {
                    e.printStackTrace();
                }
                column++;
                matchfield.setTileOfObject(column, row);
                matchfield.setImageOfField2(1);
            }
        }
    }




    private void moveToBarn(){
        // x und y von aktuellem Objekt bekommen
        // move-Methoden (moveLeft, moveRight, ...) so oft wie nötig (While-Schleife?)
    }

    private void moveToField1(Matchfield matchfield, int actualColumn, int actualRow){
        // Bild = Traktor + Hänger
        // Gespann zu Feldweg neben Feld 1 fahren
        // 'aussteigen'
        // zurück zu Barn
        // mit Harvester zum Feld
    }

    private void moveOverField1(int actualColumn, int actualRow){

    }

    private void moveToField2(int actualColumn, int actualRow){

    }

    private void moveOverField2(int actualColumn, int actualRow){

    }

    private void moveToField3(int actualColumn, int actualRow){

    }

    private void moveOverField3(int actualColumn, int actualRow){

    }

}
