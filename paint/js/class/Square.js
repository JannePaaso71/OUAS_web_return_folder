import { Rectangle } from './Rectangle.js';

export class Square extends Rectangle {
    constructor(x, y, side) {
        super(x, y, side, side);
    }
}