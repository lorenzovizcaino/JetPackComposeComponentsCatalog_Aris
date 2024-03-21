package com.antonio.jetpackcomposecomponentscatalog.ui

data class CheckInfo (val title:String, var selected:Boolean=false, var onChekedChange:(Boolean)->Unit) {
}