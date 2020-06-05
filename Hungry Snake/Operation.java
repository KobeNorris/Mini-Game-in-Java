public class Operation {
    int x, y;
    HSMap map;

    Operation(HSMap map) {
        this.map = map;
        y = map.mm.length;
        x = map.mm[0].length;
    }

    void moveUp() {
        int flag = 1;

        if (this.map.sy[0] < 1) {
            System.out.println("Bit wall !");
            this.map.result = -1;
            return;
        } else {
            for (int i = this.map.x * this.map.y - 1; i >= 0; i--) {
                if ((this.map.sx[i] == this.map.sx[0]) && (this.map.sy[i] == (this.map.sy[0] - 1))) {
                    System.out.println("Bit yourself !");
                    this.map.result = -1;
                    return;
                }
            }
            if (this.map.sy[0] - 1 == map.ym && this.map.sx[0] == map.xm) {
                for (int i = this.map.x * this.map.y - 1; i > 0; i--) {
                    this.map.sy[i] = this.map.sy[i - 1];
                    this.map.sx[i] = this.map.sx[i - 1];
                }
                this.map.sy[0] -= 1;
                this.map.length++;
                this.map.showLength.setText("Your snake is " + this.map.length + " blocks long");
                this.map.setFood();
            } else {
                for (int i = this.map.x * this.map.y - 1; i > 0; i--) {
                    if (flag == 1 && this.map.sy[i - 1] != -1 && this.map.sx[i - 1] != -1) {
                        this.map.sy[i] = -1;
                        this.map.sx[i] = -1;
                        flag = 0;
                    } else {
                        this.map.sy[i] = this.map.sy[i - 1];
                        this.map.sx[i] = this.map.sx[i - 1];
                    }
                }
                this.map.sy[0] -= 1;
            }
            this.map.refreshGraph();
        }
        this.map.repaint();
    }

    void moveLeft() {
        int flag = 1;

        if (this.map.sx[0] < 1) {
            System.out.println("Bit wall !");
            this.map.result = -1;
            return;
        } else {
            for (int i = this.map.x * this.map.y - 1; i >= 0; i--) {
                if ((this.map.sx[i] == (this.map.sx[0] - 1)) && (this.map.sy[i] == this.map.sy[0])) {
                    System.out.println("Bit yourself !");
                    this.map.result = -1;
                    return;
                }
            }
            if (this.map.sy[0] == map.ym && this.map.sx[0] - 1 == map.xm) {
                for (int i = this.map.x * this.map.y - 1; i > 0; i--) {
                    this.map.sy[i] = this.map.sy[i - 1];
                    this.map.sx[i] = this.map.sx[i - 1];
                }
                this.map.sx[0] -= 1;
                this.map.length++;
                this.map.showLength.setText("Your snake is " + this.map.length + " blocks long");
                this.map.setFood();
            } else {
                for (int i = this.map.x * this.map.y - 1; i > 0; i--) {
                    if (flag == 1 && this.map.sy[i - 1] != -1 && this.map.sx[i - 1] != -1) {
                        this.map.sy[i] = -1;
                        this.map.sx[i] = -1;
                        flag = 0;
                    } else {
                        this.map.sy[i] = this.map.sy[i - 1];
                        this.map.sx[i] = this.map.sx[i - 1];
                    }
                }
                this.map.sx[0] -= 1;
            }
            this.map.refreshGraph();
        }
        this.map.repaint();
    }

    void moveDown() {
        int flag = 1;

        if (this.map.sy[0] == (this.map.y - 1)) {
            System.out.println("Bit wall !");
            this.map.result = -1;
            return;
        } else {
            for (int i = this.map.x * this.map.y - 1; i >= 0; i--) {
                if ((this.map.sx[i] == this.map.sx[0]) && (this.map.sy[i] == (this.map.sy[0] + 1))) {
                    System.out.println("Bit yourself !");
                    this.map.result = -1;
                    return;
                }
            }
            if ((this.map.sy[0] + 1) == map.ym && this.map.sx[0] == map.xm) {
                for (int i = this.map.x * this.map.y - 1; i > 0; i--) {
                    this.map.sy[i] = this.map.sy[i - 1];
                    this.map.sx[i] = this.map.sx[i - 1];
                }
                this.map.sy[0] += 1;
                this.map.length++;
                this.map.showLength.setText("Your snake is " + this.map.length + " blocks long");
                this.map.setFood();
            } else {
                for (int i = this.map.x * this.map.y - 1; i > 0; i--) {
                    if (flag == 1 && this.map.sy[i - 1] != -1 && this.map.sx[i - 1] != -1) {
                        this.map.sy[i] = -1;
                        this.map.sx[i] = -1;
                        flag = 0;
                    } else {
                        this.map.sy[i] = this.map.sy[i - 1];
                        this.map.sx[i] = this.map.sx[i - 1];
                    }
                }
                this.map.sy[0] += 1;
            }
            this.map.refreshGraph();
        }
        this.map.repaint();
    }

    void moveRight() {
        int flag = 1;

        if (this.map.sx[0] == (this.map.x - 1)) {
            System.out.println("Bit wall !");
            this.map.result = -1;
            return;
        } else {
            for (int i = this.map.x * this.map.y - 1; i >= 0; i--) {
                if ((this.map.sx[i] == (this.map.sx[0] + 1)) && (this.map.sy[i] == this.map.sy[0])) {
                    System.out.println("Bit yourself !");
                    this.map.result = -1;
                    return;
                }
            }
            if (this.map.sy[0] == map.ym && (this.map.sx[0] + 1) == map.xm) {
                for (int i = this.map.x * this.map.y - 1; i > 0; i--) {
                    this.map.sy[i] = this.map.sy[i - 1];
                    this.map.sx[i] = this.map.sx[i - 1];
                }
                this.map.sx[0] += 1;
                this.map.length++;
                this.map.showLength.setText("Your snake is " + this.map.length + " blocks long");
                this.map.setFood();
            } else {
                for (int i = this.map.x * this.map.y - 1; i > 0; i--) {
                    if (flag == 1 && this.map.sy[i - 1] != -1 && this.map.sx[i - 1] != -1) {
                        this.map.sy[i] = -1;
                        this.map.sx[i] = -1;
                        flag = 0;
                    } else {
                        this.map.sy[i] = this.map.sy[i - 1];
                        this.map.sx[i] = this.map.sx[i - 1];
                    }
                }
                this.map.sx[0] += 1;
            }
            this.map.refreshGraph();
        }
        this.map.repaint();
    }
}