<html>
<head>
<style type="text/css">
#Username
{
  border:none;
  border-bottom:1px solid;
}

/* .screen
{
  width:100%;
  height:20px;
  background:#4388cc;
  color:#fff;
  line-height:20px;
  font-size:15px;
} */

.smallBox::before
{
  content:".";
  width:15px;
  height:15px;
  float:left;
  margin-right:10px;
}
.greenBox::before
{
  content:"";
  background:blue;
}
.redBox::before
{
  content:"";
  background:Red;
}
.emptyBox::before
{
  content:"";
  box-shadow: inset 0px 2px 3px 0px rgba(0, 0, 0, .3), 0px 1px 0px 0px rgba(255, 255, 255, .8);
    background-color:white;
} 

.seatName
{
  border:1px solid red;background:yellow;
  width: 30px;
  height: 30px;
} 



.seatGap
{
  width:40px;
}

.seatVGap
{
  height:40px;
}

table
{
  text-align:center;
}


.Displaytable
{
  text-align:center;
}
.Displaytable td, .Displaytable th {
    border: 1px solid;
    text-align: left;
}

textarea
{
  border:none;
  background:transparent;
}


input[type=checkbox]{
    content: "";
    width: 20px;
    height: 20px;
    margin:15px;
    display: inline-block;
    vertical-align:middle;
    text-align: center;
    box-shadow: inset 0px 2px 3px 0px rgba(0, 0, 0, .3), 0px 1px 0px 0px rgba(255, 255, 255, .8);
    background-color:#ccc;
}

input[type=checkbox]:checked{
    color: green;
    background-color: darkorange;
}


.screenfont{
  color: gold;
  font-size: x-large;
}
</style>
</head>
<body >
<form action="/cinematicket/booking/booking1" method="post">
<div class="inputForm" style="margin: auto;">
  <!--  BokkingId: <input type="number" id="bookingId" value=2 required/>-->
      Name: <input type="text" id="Username" required >
      Number of seatName: <input type="number" id="no_ofseatNameSelected" required>
     
      Amount: <input type="text" id="Amount" required> 
      
     
      Movie Id: <input type="number" id="movieId" required >
      
      
      Show Time: <input type="text" id="ShowTime" required>
      Show Date: <input type="text" id="ShowDate" required>
    
      <br/><br/>
      <!-- <button onclick="takeData()" style="margin-left: 223px;">Start Selecting</button> -->
    
    </div>
      
    
    <div class="seatNametructure" style="margin: auto;">
      
    <table id="seatNameBlock">
     
      <tr>
        <td colspan="14"><div class="screen screenfont"><b><i>SCREEN</i></b></div></td>
        <td rowspan="20">
          <div class="smallBox greenBox">Selected Seat</div> <br/>
          <div class="smallBox redBox">Reserved Seat</div><br/>
          <div class="smallBox emptyBox">Empty Seat</div><br/>
        </td>
        
        <br/>
      </tr>
      
      <tr>
        <td></td>
        <td>1</td>
        <td>2</td>
        <td>3</td>
        <td>4</td>
        <td>5</td>
        <td></td>
        <td>6</td>
        <td>7</td>
        <td>8</td>
        <td>9</td>
        <td>10</td>
        <td>11</td>
        <td>12</td>
    </tr>
      
    <tr>
        <td>A</td>
        <td><input type="checkbox" class="seatName" value="A1"></td>
        <td><input type="checkbox" class="seatName" value="A2"></td>
        <td><input type="checkbox" class="seatName" value="A3"></td>
        <td><input type="checkbox" class="seatName" value="A4"></td>
        <td><input type="checkbox" class="seatName" value="A5"></td>
        <td class="seatGap"></td>
        <td><input type="checkbox" class="seatName" value="A6"></td>
        <td><input type="checkbox" class="seatName" value="A7"></td>
        <td><input type="checkbox" class="seatName" value="A8"></td>
        <td><input type="checkbox" class="seatName" value="A9"></td>
        <td><input type="checkbox" class="seatName" value="A10"></td>
        <td><input type="checkbox" class="seatName" value="A11"></td>
        <td><input type="checkbox" class="seatName" value="A12"></td>
      </tr>
      
      <tr>
        <td>B</td>
        <td><input type="checkbox" class="seatName" value="B1"></td>
        <td><input type="checkbox" class="seatName" value="B2"></td>
        <td><input type="checkbox" class="seatName" value="B3"></td>
        <td><input type="checkbox" class="seatName" value="B4"></td>
        <td><input type="checkbox" class="seatName" value="B5"></td>
        <td></td>
        <td><input type="checkbox" class="seatName" value="B6"></td>
        <td><input type="checkbox" class="seatName" value="B7"></td>
        <td><input type="checkbox" class="seatName" value="B8"></td>
        <td><input type="checkbox" class="seatName" value="B9"></td>
        <td><input type="checkbox" class="seatName" value="B10"></td>
        <td><input type="checkbox" class="seatName" value="B11"></td>
        <td><input type="checkbox" class="seatName" value="B12"></td>
      </tr>
      
      <tr>
        <td>C</td>
        <td><input type="checkbox" class="seatName" value="C1"></td>
        <td><input type="checkbox" class="seatName" value="C2"></td>
        <td><input type="checkbox" class="seatName" value="C3"></td>
        <td><input type="checkbox" class="seatName" value="C4"></td>
        <td><input type="checkbox" class="seatName" value="C5"></td>
        <td></td>
        <td><input type="checkbox" class="seatName" value="C6"></td>
        <td><input type="checkbox" class="seatName" value="C7"></td>
        <td><input type="checkbox" class="seatName" value="C8"></td>
        <td><input type="checkbox" class="seatName" value="C9"></td>
        <td><input type="checkbox" class="seatName" value="C10"></td>
        <td><input type="checkbox" class="seatName" value="C11"></td>
        <td><input type="checkbox" class="seatName" value="C12"></td>
    </tr>
      
    <tr>
        <td>D</td>
        <td><input type="checkbox" class="seatName" value="D1"></td>
        <td><input type="checkbox" class="seatName" value="D2"></td>
        <td><input type="checkbox" class="seatName" value="D3"></td>
        <td><input type="checkbox" class="seatName" value="D4"></td>
        <td><input type="checkbox" class="seatName" value="D5"></td>
        <td></td>
        <td><input type="checkbox" class="seatName" value="D6"></td>
        <td><input type="checkbox" class="seatName" value="D7"></td>
        <td><input type="checkbox" class="seatName" value="D8"></td>
        <td><input type="checkbox" class="seatName" value="D9"></td>
        <td><input type="checkbox" class="seatName" value="D10"></td>
        <td><input type="checkbox" class="seatName" value="D11"></td>
        <td><input type="checkbox" class="seatName" value="D12"></td>
    </tr>
      
    <tr>
        <td>E</td>
        <td><input type="checkbox" class="seatName" value="E1"></td>
        <td><input type="checkbox" class="seatName" value="E2"></td>
        <td><input type="checkbox" class="seatName" value="E3"></td>
        <td><input type="checkbox" class="seatName" value="E4"></td>
        <td><input type="checkbox" class="seatName" value="E5"></td>
        <td></td>
        <td><input type="checkbox" class="seatName" value="E6"></td>
        <td><input type="checkbox" class="seatName" value="E7"></td>
        <td><input type="checkbox" class="seatName" value="E8"></td>
        <td><input type="checkbox" class="seatName" value="E9"></td>
        <td><input type="checkbox" class="seatName" value="E10"></td>
        <td><input type="checkbox" class="seatName" value="E11"></td>
        <td><input type="checkbox" class="seatName" value="E12"></td>
    </tr>
      
    <tr class="seatVGap"></tr>
      
    <tr>
        <td>F</td>
        <td><input type="checkbox" class="seatName" value="F1"></td>
        <td><input type="checkbox" class="seatName" value="F2"></td>
        <td><input type="checkbox" class="seatName" value="F3"></td>
        <td><input type="checkbox" class="seatName" value="F4"></td>
        <td><input type="checkbox" class="seatName" value="F5"></td>
        <td></td>
        <td><input type="checkbox" class="seatName" value="F6"></td>
        <td><input type="checkbox" class="seatName" value="F7"></td>
        <td><input type="checkbox" class="seatName" value="F8"></td>
        <td><input type="checkbox" class="seatName" value="F9"></td>
        <td><input type="checkbox" class="seatName" value="F10"></td>
        <td><input type="checkbox" class="seatName" value="F11"></td>
        <td><input type="checkbox" class="seatName" value="F12"></td>
    </tr>
      
    <tr>
        <td>G</td>
        <td><input type="checkbox" class="seatName" value="G1"></td>
        <td><input type="checkbox" class="seatName" value="G2"></td>
        <td><input type="checkbox" class="seatName" value="G3"></td>
        <td><input type="checkbox" class="seatName" value="G4"></td>
        <td><input type="checkbox" class="seatName" value="G5"></td>
        <td></td>
        <td><input type="checkbox" class="seatName" value="G6"></td>
        <td><input type="checkbox" class="seatName" value="G7"></td>
        <td><input type="checkbox" class="seatName" value="G8"></td>
        <td><input type="checkbox" class="seatName" value="G9"></td>
        <td><input type="checkbox" class="seatName" value="G10"></td>
        <td><input type="checkbox" class="seatName" value="G11"></td>
        <td><input type="checkbox" class="seatName" value="G12"></td>
    </tr>
      
    <tr>
        <td>H</td>
        <td><input type="checkbox" class="seatName" value="H1"></td>
        <td><input type="checkbox" class="seatName" value="H2"></td>
        <td><input type="checkbox" class="seatName" value="H3"></td>
        <td><input type="checkbox" class="seatName" value="H4"></td>
        <td><input type="checkbox" class="seatName" value="H5"></td>
        <td></td>
        <td><input type="checkbox" class="seatName" value="H6"></td>
        <td><input type="checkbox" class="seatName" value="H7"></td>
        <td><input type="checkbox" class="seatName" value="H8"></td>
        <td><input type="checkbox" class="seatName" value="H9"></td>
        <td><input type="checkbox" class="seatName" value="H10"></td>
        <td><input type="checkbox" class="seatName" value="H11"></td>
        <td><input type="checkbox" class="seatName" value="H12"></td>
    </tr>
      
    <tr>
        <td>I</td>
        <td><input type="checkbox" class="seatName" value="I1"></td>
        <td><input type="checkbox" class="seatName" value="I2"></td>
        <td><input type="checkbox" class="seatName" value="I3"></td>
        <td><input type="checkbox" class="seatName" value="I4"></td>
        <td><input type="checkbox" class="seatName" value="I5"></td>
        <td></td>
        <td><input type="checkbox" class="seatName" value="I6"></td>
        <td><input type="checkbox" class="seatName" value="I7"></td>
        <td><input type="checkbox" class="seatName" value="I8"></td>
        <td><input type="checkbox" class="seatName" value="I9"></td>
        <td><input type="checkbox" class="seatName" value="I10"></td>
        <td><input type="checkbox" class="seatName" value="I11"></td>
        <td><input type="checkbox" class="seatName" value="I12"></td>
    </tr>
      
    <tr>
        <td>J</td>
        <td><input type="checkbox" class="seatName" value="J1"></td>
        <td><input type="checkbox" class="seatName" value="J2"></td>
        <td><input type="checkbox" class="seatName" value="J3"></td>
        <td><input type="checkbox" class="seatName" value="J4"></td>
        <td><input type="checkbox" class="seatName" value="J5"></td>
        <td></td>
        <td><input type="checkbox" class="seatName" value="J6"></td>
        <td><input type="checkbox" class="seatName" value="J7"></td>
        <td><input type="checkbox" class="seatName" value="J8"></td>
        <td><input type="checkbox" class="seatName" value="J9"></td>
        <td><input type="checkbox" class="seatName" value="J10"></td>
        <td><input type="checkbox" class="seatName" value="J11"></td>
        <td><input type="checkbox" class="seatName" value="J12"></td>
    </tr>
      
      
    </table>
      
    <br/><button onclick="updateTextArea()" style="margin-left: 223px;">Confirm</button>
    
    </div>
          
    <br/><br/>
    
    <div class="displayerBoxes" style="margin-left: 81px;">
    
      <!-- <table class="Displaytable">
      <tr>
        <th>Name</th>
        <th>Number of seatName</th>
        <th>seatName</th>
      </tr>
      <tr>
        <td><textarea id="nameDisplay"></textarea></td>
        <td><textarea id="NumberDisplay"></textarea></td>
        <td><textarea id="seatNameDisplay"></textarea></td>
      </tr>
    </table> -->
    
    </div>
    <button  style="margin-left: 223px;">update</button>
  	</form>
  </body>
</html>
