export class Shape {
    _x
    _y
    _lineWidth
    _color

    constructor(x, y, lineWidth = 1, color = "#000") {
        this._x = x
        this._y = y
        this._lineWidth = lineWidth
        this._color = color
    }

    set setLineWidth(lineWidth) {
        this._lineWidth = lineWidth
    }

    set strokeStyle(color) {
        this._color = color
    }
}