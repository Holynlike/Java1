package ru.progwards.java1.SeaBattle.holynlike;

import ru.progwards.java1.SeaBattle.SeaBattle;

import static ru.progwards.java1.SeaBattle.holynlike.SeaBattleAlg.sector.*;

public class SeaBattleAlg {
    boolean iscorn;
    int corn, nocorn, corncount, nocorncount, markcount, effect;
    enum sector {nothing, empty, miss, hit, destroyed}

    public static sector[][] array;
    public static int rows;
    public static int cols;

    // enum sector:
    // nothing - в ячейку не стреляли, её значение неизвестно
    // empty - в ячейку стреляли, она пуста (промах)
    // miss - в ячейку стреляли, она пуста (ранение)
    // destroyed - в ячейку стреляли, попадание (ранение)
    // kill - в ячейку стреляли, попадание (убийство)

    public static void main(String[] args) {
        System.out.println("Sea battle");
        SeaBattle SB = new SeaBattle(true);

        array = new sector[SB.getSizeX()][SB.getSizeX()]; //array - карта ходов, здесь отмечены попадания, утопленные корабли и вычисленные пустые позиции
        for (int x = 0; x < SB.getSizeX(); x++) {
            for (int y = 0; y < SB.getSizeY(); y++) {
                array[x][y] = sector.nothing;
            }
        }  // проверочный массив создан и заполнен значениями "не стреляно"

        rows = SB.getSizeX() - 1;
        cols = SB.getSizeY() - 1;
        new SeaBattleAlg().battleAlgorithm(SB);
        System.out.println("Баллы: " + SB.getResult());
    }

    public void battleAlgorithm(SeaBattle seaBattle) {
        // пример алгоритма:
        // стрельба по всем квадратам поля полным перебором
        int fire_Count = 0;
        int targ = 0;
        for (int y = 0; y < seaBattle.getSizeX(); y++) {
            for (int x = 0; x < seaBattle.getSizeY(); x++) {
                if (targ <= 19 & array[x][y] != empty) {
                    SeaBattle.FireResult fireResult = seaBattle.fire(x, y); // выстрел
                    fire_Count += 1;
                    if (fireResult == SeaBattle.FireResult.HIT | fireResult == SeaBattle.FireResult.DESTROYED) {
                        targ += 1; // Попадание (ранение, либо убийство)
                        if (fireResult == SeaBattle.FireResult.DESTROYED) {
                            array[x][y] = destroyed; // Если убит
                            finishbot(x, y);
                        } else if (fireResult == SeaBattle.FireResult.HIT) {
                            array[x][y] = hit; // Если ранен
                            finishbot_corn(x, y, seaBattle);
                        }
                    }
                }
            }
        }
        System.out.println("Выстрелов всего: " + fire_Count + " (" + (fire_Count - targ) + " промахов)\nПопаданий: " + targ);
        System.out.println(nocorn + " - обход мертвеца");
        System.out.println(corn + " - обход раненого");
        System.out.println(corncount + " - вызовов финишботов");
        System.out.println(nocorncount + " - вызовов финишботкорнов");
        System.out.println(markcount + " - вызовов markcount");
        System.out.println(effect + " полей найдено Марком");
    }

    public void finishbot(int x, int y) { //если корабль убит, проставить вокруг него заведомо пустые поля
        iscorn = false;
        nocorncount++;
        if (x == 0) { // первая строка
            if (y == 0) {// указатель в ячейке 0 - 0 (левый верхний угол)
                mark(1, 0);
                mark(1, 1);
                mark(0, 1);
            } else if (y == cols) { // указатель в ячейке 0 - 9 (правый верхний угол)
                mark(0, cols - 1);
                mark(1, cols - 1);
                mark(1, cols);
            } else {
                mark(0, y - 1); // просто первая строка матрицы, не угол
                mark(0, y + 1);
                mark(1, y - 1);
                mark(1, y + 1);
                mark(1, y);
            }
        }
        if (x == rows) { // последняя строка
            if (y == cols) {// указатель в ячейке 9 - 9 (правый нижний угол)
                mark(rows - 1, cols - 1);
                mark(rows - 1, cols);
                mark(rows, cols - 1);
            } else if (y == 0) {// указатель в ячейке 9 - 0 (левый нижний угол)
                mark(rows - 1, 0);
                mark(rows - 1, 1);
                mark(rows, 1);
            } else {
                mark(rows, y - 1); // просто последняя строка матрицы, не угол
                mark(rows, y + 1);
                mark(rows - 1, y - 1);
                mark(rows - 1, y + 1);
                mark(rows - 1, y);
            }
        }
        if (x != 0 & x != rows) { // не первая и не последняя строка
            if (y == cols) { //правый столбец
                mark(x - 1, y);
                mark(x + 1, y);
                mark(x - 1, y - 1);
                mark(x + 1, y - 1);
                mark(x, y - 1);
            } else if (y == 0) { // левый столбец
                mark(x - 1, y);
                mark(x + 1, y);
                mark(x - 1, y + 1);
                mark(x + 1, y + 1);
                mark(x, y + 1);
            } else { // не угол, не первый и не последний столбец, не первая и не последняя строка
                mark(x, y - 1);
                mark(x - 1, y - 1);
                mark(x + 1, y - 1);
                mark(x, y - 1);
                mark(x - 1, y - 1);
                mark(x + 1, y - 1);
                mark(x - 1, y);
                mark(x + 1, y);
            }
        }
    }

    public void finishbot_corn(int x, int y, SeaBattle seaBattle) {
        // Если корабль ранен, проставить вокруг него по углам заведомо пустые поля
        // Сюда же добавить процедуру добивания!

        // Здесь процедура , которая отмечаетявно пустые поля вокруг раненого

        iscorn = true;
        corncount++;
        if (x == 0) { // первая строка
            if (y == 0) {// указатель в ячейке 0 - 0 (левый верхний угол)
                mark(1, 1);
            } else if (y == y) { // указатель в ячейке 0 - cols (правый верхний угол)
                mark(1, y - 1);
            } else {
                mark(0, y - 1);
                mark(0, y + 1);
            }
        } else if (x == rows) { // последняя строка
            if (y == cols) {// указатель в ячейке cols - cols (правый нижний угол)
                mark(x - 1, y - 1);
            } else if (y == 0) {// указатель в ячейке cols - 0 (левый нижний угол)
                mark(x - 1, y + 1);
            } else {
                mark(x - 1, y - 1);// последняя строка, не угловая позиция
                mark(x - 1, y + 1);
            }
        } else { // x и y не угловые (
            mark(x - 1, y - 1);// последняя строка, не угловая позиция
            mark(x - 1, y + 1);
            mark(x + 1, y - 1);// последняя строка, не угловая позиция
            mark(x + 1, y + 1);
        }

    }

    public void mark(int x, int y) {
        markcount++;
        if (iscorn) corn++;
        if (!iscorn) nocorn++;
        if (array[x][y] == sector.nothing) {
            effect++;
            array[x][y] = sector.empty;
        }
    }
}