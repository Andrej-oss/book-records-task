import {NgModule} from "@angular/core";
import {TabMenuModule} from "primeng/tabmenu";
import {TableModule} from "primeng/table";
import {CalendarModule} from "primeng/calendar";
import {SliderModule} from "primeng/slider";
import {DialogModule} from "primeng/dialog";
import {MultiSelectModule} from "primeng/multiselect";
import {ContextMenuModule} from "primeng/contextmenu";
import {DropdownModule} from "primeng/dropdown";
import {ButtonModule} from "primeng/button";
import {ToastModule} from "primeng/toast";
import {InputTextModule} from "primeng/inputtext";
import {ProgressBarModule} from "primeng/progressbar";
import {CardModule} from "primeng/card";
import {FileUploadModule} from "primeng/fileupload";

@NgModule({
    exports: [
        TabMenuModule,
        TableModule,
        CalendarModule,
        SliderModule,
        DialogModule,
        MultiSelectModule,
        FileUploadModule,
        ContextMenuModule,
        DropdownModule,
        ButtonModule,
        ToastModule,
        InputTextModule,
        ProgressBarModule,
        CardModule,
    ]
})
export class PrimeModuleModule { }
