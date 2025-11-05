var __assign = (this && this.__assign) || function () {
    __assign = Object.assign || function(t) {
        for (var s, i = 1, n = arguments.length; i < n; i++) {
            s = arguments[i];
            for (var p in s) if (Object.prototype.hasOwnProperty.call(s, p))
                t[p] = s[p];
        }
        return t;
    };
    return __assign.apply(this, arguments);
};
function updateName(song, fieldsToUpdate) {
    return __assign(__assign({}, song), fieldsToUpdate);
}
var obj1 = {
    id: 10,
    name: "old song",
};
var obj2 = updateName(obj1, { name: "new song" });
console.log(obj2);
