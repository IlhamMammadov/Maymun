package codes;

import java.util.Random;


public class MathQuestion
{
    private String operations[] = {"+", "-", "*", "/"};
    
    public String operation;
    public int fn;
    public int sn;
    public int answer;
    private Random r;
    
    public MathQuestion()
    {
        r = new Random();
        setOperation();
        setNumbers();
        setAnswer();
    }

    private void setOperation()
    {
        operation = operations[r.nextInt(4)];
    }

    private void setNumbers()
    {
        switch(operation)
        {

        case "+":
        	fn = r.nextInt(Ayarlar.addUp);
            sn = r.nextInt(Ayarlar.addUp);
            break;

        case "-":
        	fn = r.nextInt(Ayarlar.min1Up);
            sn = r.nextInt(fn==0?1:fn);
            break;
            
        case "*":
            fn = r.nextInt(Ayarlar.mulUp);
            sn = r.nextInt(Ayarlar.mulUp);
            break;

        case "/":
        	sn = r.nextInt(Ayarlar.div2Up) + 1;
            fn = r.nextInt(Ayarlar.div1Up) * sn;
            break;
        }
    }

    private void setAnswer()
    {
        
        switch (operation){



        case "+":
        	answer = fn + sn;
            break;

        case "-":
        	answer = fn - sn;
            break;
            
        case "*":
        	answer = fn * sn;
            break;
            
        case "/":
        	answer = fn / sn;
            break;
        }
    }


}