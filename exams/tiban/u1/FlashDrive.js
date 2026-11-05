"use strict";
var __createBinding = (this && this.__createBinding) || (Object.create ? (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    var desc = Object.getOwnPropertyDescriptor(m, k);
    if (!desc || ("get" in desc ? !m.__esModule : desc.writable || desc.configurable)) {
      desc = { enumerable: true, get: function() { return m[k]; } };
    }
    Object.defineProperty(o, k2, desc);
}) : (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    o[k2] = m[k];
}));
var __setModuleDefault = (this && this.__setModuleDefault) || (Object.create ? (function(o, v) {
    Object.defineProperty(o, "default", { enumerable: true, value: v });
}) : function(o, v) {
    o["default"] = v;
});
var __importStar = (this && this.__importStar) || (function () {
    var ownKeys = function(o) {
        ownKeys = Object.getOwnPropertyNames || function (o) {
            var ar = [];
            for (var k in o) if (Object.prototype.hasOwnProperty.call(o, k)) ar[ar.length] = k;
            return ar;
        };
        return ownKeys(o);
    };
    return function (mod) {
        if (mod && mod.__esModule) return mod;
        var result = {};
        if (mod != null) for (var k = ownKeys(mod), i = 0; i < k.length; i++) if (k[i] !== "default") __createBinding(result, mod, k[i]);
        __setModuleDefault(result, mod);
        return result;
    };
})();
Object.defineProperty(exports, "__esModule", { value: true });
exports.FlashDriveJsonFile = void 0;
const fs = __importStar(require("fs"));
const FlashDrive_1 = require("../model/FlashDrive");




class FlashDriveJsonFile {
    constructor(filePath) {
        this.filePath = filePath;
    }
    getFilePath() {
        return this.filePath;
    }


    save(flashDriveList) {
        const plainList = [];
        for (const flashDrive of flashDriveList) {
            plainList.push({
                id: flashDrive.getId(),
                brand: flashDrive.getBrand(),
                capacityGB: flashDrive.getCapacityGB(),
                usbVersion: flashDrive.getUsbVersion()
            });
        }
        const jsonText = JSON.stringify(plainList, null, 4);
        fs.writeFileSync(this.filePath, jsonText, "utf-8");
    }
  

    
    read() {
        const flashDriveList = [];
        if (!fs.existsSync(this.filePath)) {
            return flashDriveList;
        }
        const jsonText = fs.readFileSync(this.filePath, "utf-8");
        if (jsonText.trim() === "") {
            return flashDriveList;
        }
        const plainList = JSON.parse(jsonText);
        for (const item of plainList) {
            const flashDrive = new FlashDrive_1.FlashDrive(item.id, item.brand, item.capacityGB, item.usbVersion);
            flashDriveList.push(flashDrive);
        }
        return flashDriveList;
    }
}
exports.FlashDriveJsonFile = FlashDriveJsonFile;
