import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class DotsGame extends GraphicsProgram{
public static final int APPLICATION_WIDTH=210;
public static final int APPLICATION_HEIGHT=210;
public Button hint=new Button();
    GRect bar,line;
    Color a=Color.BLACK;
int tx[][]=new int[100][100],ix=1,iy=1,it=0;
int ty[][]=new int[100][100],fina[][]=new int[100][100];
boolean turn=true;
int player1=0,player2=0;
char playername1,playername2;
char winner=0;
    GOval as=new GOval(0,0,10,10);
int size=3,g=0,h=0;
public void draw(){
for(int j=1;j<=size;j++){
  
    for(int i=1;i<=size;i++){
        int x=30*i;
        int y=30*j;
        GOval circle=new GOval(x,y,5,5);
circle.setLocation(x,y);
circle.setFilled(true);
add(circle);

}}

}
public void line(int x,int y){
if(x>35 && x<size*30-5 && x%30>5 &&y>30 && y<=size*30+5){
    if(y%30<=6 && tx[(y-y%30)/30][(x-x%30)/30]!=1){
        tx[(y-y%30)/30][(x-x%30)/30]=1;
line=new GRect(x-x%30+3,y-y%30+0.5,27,3);
if(turn==true){
a=Color.red;
    turn=false;
winner=playername1;
}
else{
    a=Color.GREEN;
    turn=true;
winner=playername2;
}
line.setColor(a);
line.setFilled(true);
       
add(line);
    check();}
}
if(y>35 && y<size*30-5 && y%30>5 &&x>30 && x<size*30+5){
    if(x%30<=6 && ty[(y-y%30)/30][(x-x%30)/30]!=1){
        ty[(y-y%30)/30][(x-x%30)/30]=1;
line=new GRect(x-x%30+0.5,y-y%30+3,3,27);
if(turn==true){
a=Color.red;
    turn=false;
winner=playername1;
}
else{
    a=Color.GREEN;
    turn=true;
winner=playername2;
}
line.setColor(a);
line.setFilled(true);
add(line);
    check();
    }
}

}
public void run(){

hint.setLabel("hint");
addMouseListeners();
 hint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hintActionPerformed(evt);
            }
        });
setBackground(Color.yellow);
   
size=Integer.parseInt(JOptionPane.showInputDialog("enter matrix size"));
add(hint,size/2*30,5);
draw();
    playername1=JOptionPane.showInputDialog("Enter Name of 1st player").charAt(0);
    playername2=JOptionPane.showInputDialog("Enter Name of 1st player").charAt(0);

}
public void check(){
for(int i=1;i<size;i++){
for(int j=1;j<size;j++){
if(tx[i][j]==1&&tx[i+1][j]==1&&ty[i][j]==1&&ty[i][j+1]==1 && fina[i][j]!=1){
    GLabel win=new GLabel(""+winner,j*30+13,i*30+25);
win.setFont("Forte-20");
win.setColor(a);
add(win);
if(turn==false)
{player1++;
if(g!=1&&h!=1)
turn=true;
g=1;
}
else{
    player2++;
if(g!=1&&h!=1)
    turn=false;h=1;
}fina[i][j]=1;
}
}
}
if(player1+player2==(size-1)*(size-1)){
if(player1>player2){
    JOptionPane.showMessageDialog(null,"player 1 won");
}
if(player1<player2){
    JOptionPane.showMessageDialog(null,"player 2 won");
}
if(player1==player2){
    JOptionPane.showMessageDialog(null,"its a tie");
}
System.exit(0);
}
g=0;h=0;
}

public void mouseClicked(MouseEvent e){
int x=e.getX();
int y=e.getY();
line(x,y);

}

public void hintActionPerformed(ActionEvent e){
        int[][] ax = new int[100][100];        int[][] ay = new int[100][100];
int g=0;
        ax=tx;
ay=ty;
int k=0;
for(ix=1;ix<=size;ix++){
for(iy=1;iy<size;iy++){
    if(tx[ix][iy]!=1){
    ax[ix][iy]=1;
    if(ix>1){
    if((ax[ix-1][iy]==1&&ax[ix][iy]==1&&ay[ix-1][iy]==1)
 ||(ax[ix-1][iy]==1&&ax[ix][iy]==1&&ay[ix-1][iy+1]==1)
 ||(ay[ix-1][iy]==1&&ax[ix][iy]==1&&ay[ix-1][iy+1]==1)       
        ){
    ax[ix][iy]=0;
    if(iy==size-1 && ix==size)
    g=1;
    continue;}
    if(ix==size)
{
bar=new GRect(iy*30,ix*30,30,5);
add(bar);
ax[ix][iy]=0;
bar.setFilled(true);
tim.start();
k=1;
break;
}

        
    
    }if(ix<size){
    if((ax[ix][iy]==1&&ax[ix+1][iy]==1&&ay[ix][iy]==1)
 ||(ax[ix][iy]==1&&ax[ix+1][iy]==1&&ay[ix][iy+1]==1)
 ||(ay[ix][iy]==1&&ax[ix][iy]==1&&ay[ix][iy+1]==1)       
        ){
    ax[ix][iy]=0;
    if(iy==size-1 && ix==size)
    g=1;
    continue;
}
else
{
bar=new GRect(iy*30,ix*30,30,5);
add(bar);
ax[ix][iy]=0;
bar.setFilled(true);
tim.start();
k=1;
break;
}
    }

}
}
if(k==1)
   break;
if(iy==size && ix==size)
    g=1;

}
if(g==1){
for(ix=1;ix<size;ix++){
for(iy=1;iy<=size;iy++){
    if(ty[ix][iy]!=1){
    ay[ix][iy]=1;
 
    if(iy>1){
    if((ay[ix][iy-1]==1 && ay[ix][iy]==1&&ax[ix][iy-1]==1)
 ||(ay[ix][iy-1]==1&&ay[ix][iy]==1&&ax[ix+1][iy-1]==1)
 ||(ax[ix][iy-1]==1&&ay[ix][iy]==1&&ax[ix+1][iy-1]==1)       
        ){
    ay[ix][iy]=0;
    continue;
}
    if(iy==size)
{
bar=new GRect(iy*30,ix*30,5,30);
add(bar);
ay[ix][iy]=0;
bar.setFilled(true);
tim.start();
k=1;
break;
}
    }
    if(iy<size){
    if((ay[ix][iy]==1&&ay[ix][iy+1]==1&&ax[ix][iy]==1)
 ||(ay[ix][iy]==1&&ay[ix][iy+1]==1&&ax[ix+1][iy]==1)
 ||(ax[ix][iy]==1&&ay[ix][iy]==1&&ax[ix+1][iy]==1)       
        ){
    ay[ix][iy]=0;
    continue;
}
    else
{
bar=new GRect(iy*30,ix*30,5,30);
add(bar);
ay[ix][iy]=0;
bar.setFilled(true);
tim.start();
k=1;
break;
}
    }

    
    




}

}
if(k==1)
   break;
}
}
}
Timer tim=new Timer(100,new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
           blink();
        
        }            //To change body of generated methods, choose Tools | Templates.
        
    });
public void blink(){

if(bar.isVisible())    
    bar.setVisible(false);
else
  bar.setVisible(true);
it++;
if(it==10){
    remove(bar);
    tim.stop();
    
it=0;
}

}

}