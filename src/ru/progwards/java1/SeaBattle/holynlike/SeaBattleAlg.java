package ru.progwards.java1.SeaBattle.holynlike;

import ru.progwards.java1.SeaBattle.SeaBattle;

import static ru.progwards.java1.SeaBattle.holynlike.SeaBattleAlg.sector.*;

public class SeaBattleAlg {
    boolean iscorn;
    int corn, nocorn, corncount, nocorncount, markcount, effect;

    enum sector {nothing, empty, miss, hit, destroyed}

    public static sector[][] array;
    public static int cols;
    public static int rows;
    int fire_Count = 0;
    int targ = 0;
    // enum sector:
    // nothing - в ячейку не стреляли, её значение неизвестно
    // empty - в ячейку стреляли, она пуста (промах)
    // miss - в ячейку стреляли, она пуста (ранение)
    // destroyed - в ячейку стреляли, попадание (ранение)
    // kill - в ячейку стреляли, попадание (убийство)

    public void battleAlgorithm(SeaBattle seaBattle) {
        array = new sector[seaBattle.getSizeX()][seaBattle.getSizeX()]; //array - карта ходов, здесь отмечены попадания, утопленные корабли и вычисленные пустые позиции
        for (int x = 0; x < seaBattle.getSizeX(); x++) {
            for (int y = 0; y < seaBattle.getSizeY(); y++) {
                array[x][y] = sector.nothing;
            }
        }  // проверочный массив создан и заполнен значениями "не стреляно"
        cols = seaBattle.getSizeX() - 1;
        rows = seaBattle.getSizeY() - 1;
        // пример алгоритма:
        // стрельба по всем квадратам поля полным перебором

        for (int x = 0; x < seaBattle.getSizeX(); x++) { // строки
            for (int y = 0; y < seaBattle.getSizeY(); y++) { // столбцы
                Fires(x, y, seaBattle); // выстрел по указанным координатам
            }
        }
        {
            System.out.println(seaBattle.toString());
            System.out.println("Выстрелов всего: " + fire_Count + " (" + (fire_Count - targ) + " промахов)\nПопаданий: " + targ);
            System.out.println(nocorn + " - обход мертвеца");
            System.out.println(corn + " - обход раненого");
            System.out.println(corncount + " - вызовов финишботкорнов");
            System.out.println(nocorncount + " - вызовов финишботов");
            System.out.println(markcount + " - вызовов mark");
            System.out.println(effect + " полей найдено Марком");
            System.out.println("Баллы: " + seaBattle.getResult());
        }
    }

    public void Fires(int x, int y, SeaBattle seaBattle) {
        if (x < 0 || x > cols || y < 0 || y > rows){
            return;
        }  // Если аргументы мимо моря, ничего не делаем
        if (targ < 20 & array[x][y] == nothing) { // Если нет 20 попаданий и поле не исследовано, стреляем
            SeaBattle.FireResult fireResult = seaBattle.fire(x, y); // выстрел
            fire_Count += 1; // Добавляем + 1 к счетчику выстрелов
            if (fireResult == SeaBattle.FireResult.DESTROYED) {
                targ += 1;
                array[x][y] = sector.destroyed; // Если убит
                finishbot(x, y);
            } else if (fireResult == SeaBattle.FireResult.HIT) {
                targ += 1;
                array[x][y] = sector.hit; // Если ранен
                finishbot_corn(x, y, seaBattle);
            } else if (fireResult == SeaBattle.FireResult.MISS) {
                array[x][y] = sector.miss;
            }
        }
    }

    public void finishbot(int x, int y) { //если корабль убит, проставить вокруг него заведомо пустые поля
        iscorn = false;
        nocorncount++; // счет вызовов процедуры обводки
        if (x == 0) { // первая строка
            if (y == 0) {// указатель в ячейке 0 - 0 (левый верхний угол)
                mark(1, 0);
                mark(1, 1);
                mark(0, 1);
            } else if (y == rows) { // указатель в ячейке 0 - 9 (правый верхний угол)
                mark(0, rows - 1);
                mark(1, rows - 1);
                mark(1, rows);
            } else {
                mark(0, y - 1); // просто первая строка матрицы, не угол
                mark(0, y + 1);
                mark(1, y - 1);
                mark(1, y + 1);
                mark(1, y);
            }
        }
        if (x == cols) { // последний столбец
            if (y == rows) { // правый нижний угол
                mark(cols - 1, rows - 1);
                mark(cols - 1, rows);
                mark(cols, rows - 1);
            } else if (y == 0) {// левый нижний угол
                mark(cols - 1, 0);
                mark(cols - 1, 1);
                mark(cols, 1);
            } else {            // просто последний столбец матрицы, не угол
                mark(cols, y - 1);
                mark(cols, y + 1);
                mark(cols - 1, y - 1);
                mark(cols - 1, y + 1);
                mark(cols - 1, y);
            }
        }
        if (x != 0 & x != cols) { // не первый и не последний столбец
            if (y == rows) { // последняя строка
                mark(x - 1, y);
                mark(x + 1, y);
                mark(x - 1, y - 1);
                mark(x + 1, y - 1);
                mark(x, y - 1);
            } else if (y == 0) { // верхняя строка
                mark(x - 1, y);
                mark(x + 1, y);
                mark(x - 1, y + 1);
                mark(x + 1, y + 1);
                mark(x, y + 1);
            } else { // не угол, не первый и не последний столбец, не первая и не последняя строка
                mark(x, y - 1);
                mark(x - 1, y - 1);
                mark(x + 1, y - 1);
                mark(x, y + 1);
                mark(x - 1, y + 1);
                mark(x + 1, y + 1);
                mark(x - 1, y);
                mark(x + 1, y);
            }
        }
    }

    public void finishbot_corn(int x, int y, SeaBattle seaBattle) {
        // Если корабль ранен, проставить вокруг него по углам заведомо пустые поля
        // Здесь процедура , которая отмечаетявно пустые поля вокруг раненого

        iscorn = true;
        corncount++; // счет вызовов процедуры отметки углов
        if (x == 0 && y == 0) {                  // левый верхний угол
            mark(1, 1);
//            Fires(0, 1, seaBattle);       // добивание по горизонтали
//            Fires(1, 0, seaBattle);       // добивание по вертикали
        } else if (x == 0 && y == rows) {        // нижний левый
            mark(1, y - 1);
//            Fires(1, y, seaBattle);          // добивание по горизонтали
//            Fires(0, y - 1, seaBattle);     // добивание по вертикали
        } else if (x == 0 && y > 0 && y < rows) { // первый столбец, не угловая позиция
            mark(1, y - 1);
            mark(1, y + 1);
//            Fires(0, y - 1, seaBattle);
//            Fires(1, y, seaBattle);
//            Fires(0, y + 1, seaBattle);
        } else if (x == cols & y == rows) {     // правый нижний угол
            mark(x - 1, y - 1);
//            Fires(x - 1, y, seaBattle);
//            Fires(x, y - 1, seaBattle);
        } else if (x == cols & y == 0) {        // правый верхний угол
            mark(x - 1, 1);
//            Fires(x - 1, 0, seaBattle);
//            Fires(x, 1, seaBattle);
        } else if (x == cols & y > 0 & y < rows) { // последний стролбец, не угловая позиция
            mark(x - 1, y - 1);
            mark(x - 1, y + 1);
//            Fires(x - 1, y - 1, seaBattle);
//            Fires(x, y, seaBattle);
//            Fires(x - 1, y + 1, seaBattle);
        } else if (x > 0 & x < cols & y == 0) {  // первая строка, не угол
            mark(x - 1, 1);
            mark(x + 1, 1);
//            Fires(x - 1, 0, seaBattle);
//            Fires(x, 1, seaBattle);
//            Fires(x + 1, 0, seaBattle);
        } else if (x > 0 & x < cols & y == rows) {// последняя строка, не угол
            mark(x + 1, y - 1);
            mark(x - 1, y - 1);
//            Fires(x + 1, y, seaBattle);
//            Fires(x, y - 1, seaBattle);
//            Fires(x - 1, y, seaBattle);
        } else if (x > 0 & x < cols & y > 0 & y < rows) { // не крайние и не угловые позиции
            mark(x - 1, y - 1);
            mark(x - 1, y + 1);
            mark(x + 1, y - 1);
            mark(x + 1, y + 1);
//            Fires(x - 1, y, seaBattle);
//            Fires(x, y-1, seaBattle);
//            Fires(x, y+1, seaBattle);
//            Fires(x + 1, y, seaBattle);
        }
    }

    public void mark(int x, int y) { // Отметить указанные поля (обводка)
        markcount++; // счетчик вызовов процедуры пометки
        if (iscorn) corn++;
        if (!iscorn) nocorn++;
        if (x < 0 || x > cols || y < 0 || y > rows){
            return;
        }  // Если аргументы мимо моря, ничего не делаем
        if (array[x][y] == nothing || array[x][y] == miss) {
            effect++;
            array[x][y] = empty;
        }
    }
}