import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { EwTeamComponent } from './components/ew-teams/ew-team/ew-team.component';
import { PlayerComponent } from './components/players/player/player.component';
import { AppRoutingModule } from './app-routing.module';
import {HttpClientModule} from "@angular/common/http";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSliderModule } from '@angular/material/slider';
import { MatToolbarModule } from "@angular/material/toolbar";
import { MatIconModule } from "@angular/material/icon";
import { FormsModule } from '@angular/forms';
import {MatTableModule, MatFooterCell, MatFooterRowDef} from '@angular/material/table';
import {MatCell, MatCellDef} from '@angular/material/table';
import {MatColumnDef} from '@angular/material/table';
import {MatCheckbox} from '@angular/material/checkbox';
import { MaterialModule } from './material/material.module';
import { EwTeamDetailsComponent } from './components/ew-teams/ew-team-details/ew-team-details.component';
import { EwTeamCreateComponent } from './components/ew-teams/ew-team-create/ew-team-create.component';


@NgModule({
  declarations: [
    AppComponent,
    EwTeamComponent,
    PlayerComponent,
    EwTeamDetailsComponent,
    EwTeamCreateComponent,
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSliderModule,
    MatToolbarModule,
    MatIconModule,
    FormsModule,
    MatTableModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
