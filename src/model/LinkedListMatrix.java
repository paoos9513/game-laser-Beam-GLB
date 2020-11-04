package model;

import java.util.Random;

public class LinkedListMatrix {

    private final String LEFT_MIRROR = "\\";
    private final String RIGHT_MIRROR = "/";
    private final String START = "S";
    private final String END = "E";
    private final String ERROR = "X";
    private final String HORIZONTAL = "H";
    private final String VERTICAL = "V";
    private Node first;
    private Node nodeSelected;
    private Node backupNodeSelected;
    private Node laser;
    private int numRows;
    private int numColumn;
    Random random = new Random();
    String idColumns = "  ";


    private int correctAnswers = 0;
    private int mirrors;

    //METODO CONSTRUCTOR
    public LinkedListMatrix(int numRows, int numColumn, int mirrors) {
        this.numRows = numRows;
        this.numColumn = numColumn;
        this.mirrors = mirrors;
        createMatrix();
        addMirrors(first, first.getDown(), mirrors);
    }
    //CREACION DE LA MATRIZ
    private void createMatrix() {
        //System.out.println("vamos a crear la matriz");
        first = new Node(0, 0);
        //System.out.println("se crea el first");
        createRow(0, 0, first);
    }
    //CREACION DE LAS FILAS
    private void createRow(int i, int j, Node currentFirstRow) {
        //System.out.println("en createRow con la fila " + i);
        createCol(i, j + 1, currentFirstRow, currentFirstRow.getUp());
        if (i + 1 < numRows) {
            Node downFirstRow = new Node(i + 1, j);
            downFirstRow.setUp(currentFirstRow);
            currentFirstRow.setDown(downFirstRow);
            createRow(i + 1, j, downFirstRow);
        }
    }
    //CREACION DE LAS COLUMNAS
    private void createCol(int i, int j, Node prev, Node rowPrev) {
        if (j < numColumn) {
            //System.out.println("   en createCol con la columna " + j);
            Node current = new Node(i, j);
            current.setPrev(prev);
            prev.setNext(current);

            if (rowPrev != null) {
                rowPrev = rowPrev.getNext();
                current.setUp(rowPrev);
                rowPrev.setDown(current);
            }
            createCol(i, j + 1, current, rowPrev);
        }
    }
    // MOSTRAR MATRIZ
    public String toString() {
        String msg;
        msg = toStringRow(first);
        idColumns = "  ";
        columnsIds(first.getColumn());
        return idColumns + msg;
    }
    // METODO PARA AGREGAR ESPEJOS EN LOS ESPACIOS VACIOS
    public void addMirrors(Node current, Node nextRowFirstColumn, int mirrors) {
        if (mirrors > 0) {
            int totalMirrorsAvailable = mirrors;
            if (hasMirror() && current.getMirror().equals("")) {
                totalMirrorsAvailable = mirrors - 1;
                current.addMirror(mirrorType());
            }
            if (current.getNext() != null) {
                addMirrors(current.getNext(), nextRowFirstColumn, totalMirrorsAvailable);
            } else if (current.getDown() != null) {
                addMirrors(nextRowFirstColumn, nextRowFirstColumn.getDown(), totalMirrorsAvailable);
            } else {
                addMirrors(first, first.getDown(), totalMirrorsAvailable);
            }
        }
    }
    //METODO PARA BUSCAR EL NODO POR IDENTIFICACION
    public void scanNodesById(Node current, Node nextRowFirstColumn, String nodeContent) {
        if (current != null) {
            if (!current.getId().equals(nodeContent)) {
                if (current.getNext() != null) {
                    scanNodesById(current.getNext(), nextRowFirstColumn, nodeContent);
                } else if (current.getDown() != null) {
                    scanNodesById(nextRowFirstColumn, nextRowFirstColumn.getDown(), nodeContent);
                } else {
                    scanNodesById(first, first.getDown(), nodeContent);
                }
            } else {
                nodeSelected = current;
            }
        } else {
            nodeSelected = null;
        }
    }
    //METODO PARA AGREGAR LOS ESPEJOS DE FORMA ALEATORIA
    public boolean hasMirror() {
        return random.nextInt(((numColumn * numRows) / 2)) == 0;
    }
    //METODO PARA UBICAR LA POSICION DEL ESPEJO DE FORMA ALEATORIA
    public String mirrorType() {
        return random.nextInt(2) == 0 ? RIGHT_MIRROR : LEFT_MIRROR;
    }
    // METODO PARA NOMBRAR LAS FILAS DE 1 HASTA N
    private String idRow(int row) {
        return (row + 1) + " ";
    }
    //MOSTRAR MATRIZ CON EL NOMBRE DE LAS FILAS Y LAS COLUMNAS
    private String toStringRow(Node firstRow) {
        String msg = "";
        if (firstRow != null) {
            msg = idRow(firstRow.getRow()) + toStringCol(firstRow) + "\n";
            msg += toStringRow(firstRow.getDown());
        }
        return msg;
    }
    // METODO PARA NOMBRAR LAS COLUMNAS DE LA A HASTA LA Z (SIN CONTAR LA Ñ)
    private void columnsIds(int columnPosition) {
        if (columnPosition < numColumn) {
            idColumns += " " + (char) ('A' + columnPosition) + " ";
            columnsIds(columnPosition + 1);
        } else {
            idColumns += "\n";
        }
    }
    //MOSTRAR MATRIZ CON EL NOMBRE DE LA COLUMNA
    private String toStringCol(Node current) {
        String msg = "";
        if (current != null) {
            msg = current.toString();
            msg += toStringCol(current.getNext());
        }
        return msg;
    }
//ACCION DE TIRAR EL RAYO LASER (SELECCIONAR EL NODO)

    public void shootLaserAction(String action) {
        String idRow = action.substring(0, 1);
        String idColumn = action.substring(1, 2);
        String direction = "";
        try {
            direction = action.substring(2, 3);
        } catch (Exception ignored) {
        }
        shootLaser(idRow + idColumn, direction, first);
    }
    // SELLECCION DEL NODO ADIVINAR UN ESPEJO
    public void selectNode(String action) {
        String idRow = action.substring(0, 1);
        String idColumn = action.substring(1, 2);
        scanNodesById(first, first.getDown(), idRow + idColumn);
        if (backupNodeSelected !=null) {
            if (backupNodeSelected.getMark().equals(ERROR)) {
                backupNodeSelected.setMark(" ");
            }
        }
        backupNodeSelected = nodeSelected;
        if (nodeSelected.getMirror().equals("")) {
            nodeSelected.setMark(ERROR);
        } else {
            correctAnswers ++;
            nodeSelected.setMark(nodeSelected.getMirror());
            if (correctAnswers ==  this.mirrors) {
                win();
            }
        }
    }
    //GANO EL JUEGO
    public void win() {
        System.out.println("Gano");
    }
    //DISPARAR LASER
    private void shootLaser(String nodeId, String direction, Node current) {
        scanNodesById(current, current.getDown(), nodeId);
        nodeSelected.setMark(START);
        if ( !direction.equals("") &&
                (nodeSelected.getRow() == 0 && nodeSelected.getColumn() ==0)
                || (nodeSelected.getRow() == numRows && nodeSelected.getColumn() == numColumn)
                || (nodeSelected.getRow() == 0 && nodeSelected.getColumn() == numColumn)
                || (nodeSelected.getRow() == numRows && nodeSelected.getColumn() == 0)
        )  {
            System.out.println(direction);
            switch (direction) {
                case VERTICAL:
                    if (nodeSelected.getUp() == null){
                        shootToDown(nodeSelected, nodeSelected);
                    } else {
                        shootToUp(nodeSelected, nodeSelected);
                    }
                    break;
                case HORIZONTAL:
                    if (nodeSelected.getPrev() == null){
                        shootToRight(nodeSelected, nodeSelected);
                    } else {
                        shootToLeft(nodeSelected, nodeSelected);
                    }
                    break;
            }
        } else {
            System.out.println(nodeSelected.getColumn());
            System.out.println(nodeSelected.getRow());
            if (nodeSelected.getColumn() == 0) {
                shootToRight(nodeSelected, nodeSelected);
            } else if (current.getColumn() == numColumn) {
                shootToLeft(nodeSelected, nodeSelected);
            }else if (current.getRow() == 0) {
                shootToDown(nodeSelected, nodeSelected);
            } else if (current.getRow() == numRows) {
                shootToUp(nodeSelected, nodeSelected);
            }
        }
    }
    //DISPARAR A LA DERECHA
    public void shootToRight(Node current, Node before) {
        if (current == null) {
            laser = before;
            before.setMark(END);
        } else {
            String mirror = current.getMirror();
            if (mirror.equals(LEFT_MIRROR) || mirror.equals(RIGHT_MIRROR)) {
                laser = current;
                if (mirror.equals(LEFT_MIRROR)) {
                    shootToDown(current.getDown(), current);
                } else {
                    shootToUp(current.getUp(), current);
                }
            } else {
                shootToRight(current.getNext(), current);
            }
        }
    }
    //DISPARAR A LA IZQUIERDA
    public void shootToLeft(Node current, Node before) {
        if (current == null) {
            laser = before;
            before.setMark(END);
        } else {
            String mirror = current.getMirror();
            if (mirror.equals(LEFT_MIRROR) || mirror.equals(RIGHT_MIRROR)) {
                laser = current;
                if (mirror.equals(LEFT_MIRROR)) {
                    shootToUp(current.getUp(), current);
                } else {
                    shootToDown(current.getDown(), current);
                }
            } else {
                shootToLeft(current.getPrev(), current);
            }
        }
    }
    //DISPARAR HACIA ABAJO
    public void shootToDown(Node current, Node before) {
        if (current == null) {
            laser = before;
            before.setMark(END);
        } else {
            String mirror = current.getMirror();
            if (mirror.equals(LEFT_MIRROR) || mirror.equals(RIGHT_MIRROR)) {
                laser = current;
                if (mirror.equals(LEFT_MIRROR)) {
                    shootToRight(current.getNext(), current);
                } else {
                    shootToLeft(current.getPrev(), current);
                }
            } else {
                shootToDown(current.getDown(), current);
            }
        }
    }
    //DISPARAR HACIA ARRIBA
    public void shootToUp(Node current, Node before) {
        if (current == null) {
            laser = before;
            before.setMark(END);
        } else {
            String mirror = current.getMirror();
            if (mirror.equals(LEFT_MIRROR) || mirror.equals(RIGHT_MIRROR)) {
                laser = current;
                if (mirror.equals(LEFT_MIRROR)) {
                    shootToLeft(current.getPrev(), current);
                } else {
                    shootToRight(current.getNext(), current);
                }
            } else {
                shootToUp(current.getUp(), current);
            }
        }
    }
}
