package com.example.rsa_rental_service_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Explore extends AppCompatActivity {

    private RecyclerView recyclerView;
    public String[] images; public String[] productname;public String[] productdesc;public String[] rentername;public String[] price;public String[] number;
    String username="";
    String lattitude="";
    String longitude="";
    private RecyclerAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        Intent intent =getIntent();

        username=intent.getStringExtra("username");
        lattitude=intent.getStringExtra("lattitude");
        longitude=intent.getStringExtra("longitude");
        System.out.println("************************************************in the Explore class oncrreate");
        JSONObject jaso=new JSONObject();
        try {
            jaso.put("code","201");
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println("/////////////////////////////////yha ");
        }

        try {
            System.out.println("bhejne se phle======================================================");
            Backend_network.dout.writeUTF(jaso.toString());
            System.out.println("bhejne k baad======================================================");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String z="";
        try {
            z=Backend_network.din.readUTF();
        } catch (Exception le) {
            le.printStackTrace();
        }
        System.out.println("z is"+z);

        int n= Integer.parseInt(z);
        images=new String[n];
        productname=new String[n];
        price=new String[n];
        productdesc=new String[n];
        rentername=new String[n];
        number=new String[n];
        System.out.println("********************************************yha tk sab sahi chra hai");
//        for(int i=1;i<=n;i++)
//        {
//
//            try {
//                Backend_network.dout.writeUTF(""+i);
//                System.out.println("i have sent "+i);
//                String k=Backend_network.din.readUTF();
//                System.out.println("readed from server umage string is"+k);
//                images[i-1]=k;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//        for(int i=1;i<=n;i++)
//        {
//
//            try {
//                Backend_network.dout.writeUTF(""+i);
//                System.out.println("i have sent "+i);
//                String k=Backend_network.din.readUTF();
//                System.out.println("readed from server product string is"+k);
//                productname[i-1]=k;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//        for(int i=1;i<=n;i++)
//        {
//
//            try {
//                Backend_network.dout.writeUTF(""+i);
//                System.out.println("i have sent "+i);
//                String k=Backend_network.din.readUTF();
//                System.out.println("readed from server product string is"+k);
//                productdesc[i-1]=k;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//        for(int i=1;i<=n;i++)
//        {
//
//            try {
//                Backend_network.dout.writeUTF(""+i);
//                System.out.println("i have sent "+i);
//                String k=Backend_network.din.readUTF();
//                System.out.println("readed from server product string is"+k);
//                price[i-1]=k;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//        for(int i=1;i<=n;i++)
//        {
//
//            try {
//                Backend_network.dout.writeUTF(""+i);
//                System.out.println("i have sent "+i);
//                String k=Backend_network.din.readUTF();
//                System.out.println("readed from server product string is"+k);
//                rentername[i-1]=k;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//        for(int i=1;i<=n;i++)
//        {
//
//            try {
//                Backend_network.dout.writeUTF(""+i);
//                System.out.println("i have sent "+i);
//                String k=Backend_network.din.readUTF();
//                System.out.println("readed from server product string is"+k);
//                number[i-1]=k;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }




        for(int i=1;i<=n;i++)
        {

            try {
                Backend_network.dout.writeUTF("" + i);
                System.out.println("i have sent " + i);
                String k = Backend_network.din.readUTF();
                JSONObject expe = null;
                try {
                    expe = new JSONObject(k);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                double dis = 0;
                try {
                    dis = returnn.distance(Double.parseDouble(lattitude), Double.parseDouble(longitude), Double.parseDouble(expe.getString("lattitude")), Double.parseDouble(expe.getString("longitude")));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                System.out.println("readed from server umage string is" + k);
                System.out.println("dis is============================================:"+dis);
                if(dis<=10) {
                    try {
                        images[i - 1] = expe.getString("image");
                        productname[i - 1] = expe.getString("productname");
                        productdesc[i - 1] = expe.getString("productdesc");
                        price[i - 1] = expe.getString("price");
                        rentername[i - 1] = expe.getString("rentern");
                        number[i - 1] = expe.getString("phone");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                else
                {
                    images[i - 1] = "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEB\n" +
                            "AQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQH/2wBDAQEBAQEBAQEBAQEBAQEBAQEBAQEB\n" +
                            "AQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQH/wAARCAD6ALsDASIA\n" +
                            "AhEBAxEB/8QAHgAAAwADAAMBAQAAAAAAAAAABQYHAwQIAQIJCgD/xABBEAACAgIBAwMEAQIFAQcB\n" +
                            "BwUBAgMEBREhBhIxABNBBxQiUWEVMiNCcYGRCBYkUqGxwdHwCRcYJSYz8TRTcoLC/8QAHAEAAgMB\n" +
                            "AQEBAAAAAAAAAAAAAwQBAgUABgcI/8QAOBEAAgIBAwMCBAQFBAICAwAAAQIDESEEEjEAQVEiYQUT\n" +
                            "cYGRobHwBhQyQtEjweHxB1IVciRigv/aAAwDAQACEQMRAD8A07P0+o5W2t+29kNEtZqZrWJqklSx\n" +
                            "WnNlLEc1Z4Xm7plhYwW/erkwIGhdWkDtl/F55atCDFQfdn3qsd6z71WvbSqJUS1JWimrGhLaaD3J\n" +
                            "FEvsxdw0E/IFGDD0Hq1Ktd5pLTw14oWsSEmWw8SKrTS7JHdKwMja4LE69O9OuzL7gjKBTo9rLrnW\n" +
                            "/wADz/PGjvXJ16yWlddoJ+YsROxWsoLIugKIBq6sAmrvtphQRRHJsGzdAgnI8dvBNdupQ/SS9H0I\n" +
                            "79DF5XqK5DYCRaf3ZqUFuUxtMsCbIoY9JZJGqY6rYmbuZq9N3VFiL4Xob+lNa6kKx2ur8njITans\n" +
                            "MjVY7yVERo4TBj60yV+9UhDtUeysC9gQM8yyV+GIge2dMG7SCSvGx/p41+zyf2Sp9FYqBkA7UUhS\n" +
                            "O5j2g+dnZ2eOBrxzzojxxnkdWFnexPzHzciegiNs0FDAmhW7+7gdRQU47VQP2o9qqgc5uxddc/Yv\n" +
                            "B38jQp9Y9eVYVymHja9Sx+Nx05SrVMMc8a2ITVs5eS8ssYmsxwxVzFOntJVMcbe6yY7FV/qF/TOo\n" +
                            "7ENvH0Me0M+HjW5XnazYjswST2ZaTC1j2qzJWmpRG5XmuvDKbVVcTYihnlr09VYu5pAiJGhkaRm7\n" +
                            "FRR/c7sW/FQAWJOtDZJHJ9IOEnsz9aSVOmhT/wCy/wBpNkOp2sYezSlbKTSe3jruFuiGpDlkzCRT\n" +
                            "Ce735CtHDjgyyI08KyljlkkEroojaJGZHFiKGI3uiVaKgy7tqlyd7NsA3OD1WiCOaNDyc1nzVfs9\n" +
                            "sGLwsPWk9jKZzC26sFN8hiKuDzmHiFeetYEDSXGkt13nmeVUQK1Uw14dy1w1pg8x3MvWzVTNdKdP\n" +
                            "dPs+Px9inlqlt4koS1qVepUrvWlNeazVvrLCyRQ0ZqgswLLYYZCv2CH3HbKdRrgFnns4zIyU4YYn\n" +
                            "a7Vir2IFlnl9iCuYhY++aWWYwx7r0pkBnjbu7RL7fr9PsLMcfbzmRrVYrvUcxy8J9iuuUip5HV2O\n" +
                            "jk7NVRDJLVew8EaRPYEMMUETXrbL7g5SdpmcKsKgpDE3rQu6lfSCctFu+YSwJBKk831YDsLrmzg2\n" +
                            "Dzj3wALqyAOitDFQ1q8VeJZGSLu/KeaSeRyxLM8s8zvLKxY9xZ2ZiSdaAAG79kjDteMKTv8AIb53\n" +
                            "wp+OONg73rQOjz6KCPtLJypDabY7SO3ka892/k74/R4De0arI3aO9d+S349+geNgkkb/ANtkbA2f\n" +
                            "QFNmz5vzd1fI9zyO3Vs4F4wcCu4q+2AR98ZPS7NReIL7Y2N7P7J8Md6A1rjWtk8nfGsf9PLF2U/4\n" +
                            "hXY4O0YDgDXBB2dEgk8bHG/Tiqr2j8FOgdHySd8nzvxxsEtwAPPrUmhbTyIpLAA7UFSda4AJ1pT8\n" +
                            "89w/e9eu+l++OP39uhEgCz+XSBm79PB469lclIIaeLqz27s5VnKQ1YmklfsQF3ftUlURGd3IRQzs\n" +
                            "B65c+m8GZ+q31GzfXnUOLkp9K4Gw2N6cr5BZIrKTxSVrEWOFX32jgmx7RLkc9N7LvJmbqYZpnTp/\n" +
                            "sR7/AOpTqzqjpfp7par0glGz1T1P1Zi8XhsXfjYplbxmSGjEvajKjU8lax+ashpq6SUMVajaZRIz\n" +
                            "ejf1EyyfRX6MPDiE+96jjo1OmemoViX7zOdb59zVrW5EDIbVu1lrNjNZIhu+aOK5OzFyzlSRlaRt\n" +
                            "zERaVRLKB/cxFot8EAW1dztvkdfQPgOj1Gl+E6R9LDE/xf8Ai/Vy/B/hMryMG0mkilih1+oC7VEJ\n" +
                            "llkSD+ZLOgh+eUMbwTAxrJ9P9MfVb/8AEV1L1121fpxTqQdBYvMhI1sY6v8AT+HI5HqXqXHz2IbK\n" +
                            "Ry0ep7tladyGvIksmERClhYzGeP+n/rt9SZOlul/qD04uP6hsfSy9m8VPPdzGFpdbde/QyjNH/Vr\n" +
                            "3UvSdp4jK2PmxmPSlmcXkLduDKrkQaUkn3V69WP+sDqBvpb9E/pn/wBOHSc7yZ/rcU6+bkgjJmt0\n" +
                            "cdNFbzN217PfYWXqLqeyL1hwJPuI6+TikLq7d8Z6J+llvrr6l/T76KdQ9DfT6CDGY3BXouv+k6/V\n" +
                            "VK91L9JMZRizs2ayUVzLX8HNY6qlNHG27ElPFZzF5LL6hiNK1MDiamRxqEhQEShUErBiCZ55FlWM\n" +
                            "kBgBDyhPk2yjn7R/Dnw3QN/Dmp+M/EWWX4PJqdQ3wjTamKOVIP4d/h74avwbW/FP5aTU6WQz/G4k\n" +
                            "Ca2OKZmZoU1EenmkSJ4Oisv0T0v9QMT9U+pq/T9lB9Uulfp11h9PYM5hsPj+reiurOrb1zpeFMfc\n" +
                            "qSTT45M7aw/T+YnhGTRJHktfediyWGXvbO5WtgKtCvJDdydtYUiWtSjjsZB6dKKP77JzRFoS8NSA\n" +
                            "e7Mybknmkhp1IprtyrWlQ+m+j+n+p8zY69f7m3FBk4KnSqVcrk4MLLi+lpLNWlelxNS5Hib8ozU+\n" +
                            "bv427aq2ilWenNXdD+RYc11Sy56fpzH1MYMwK2Kdbl6eZaiC9YudtC69eF5Kk9qOrNJiGdpK9uX3\n" +
                            "k2liKvWu+g+G6Y/MdwqvvUsxDBAyh2O92IoJukJoE0pAUjFfB/4s+Nv8SXSaBjqVT4czf/jTtvXR\n" +
                            "sdD8M0R0kZLEs0CfDkWeZo4Xl1BkeVGkBkc3PVrWo4J4ZI5a9iJbFazXMckFmGVQ8UscsZYMjqyu\n" +
                            "rKdFGDBipDFTzuEW/Qu0tiEX6tiq0sfekqNLA6e4kkbQyCRS/cGWRHUglHVtEUGGnBSgSpUjVIIl\n" +
                            "AiiXftwJ+XbFCrELHEuyqRJ+EaBI0CIAvqJ/U/IZT+pY3patauYWr1HU9mHN0LVeOSG6b1ahHRRT\n" +
                            "jr92rNakyEMkWRhpZWnVFcjJVa1WR53f08TTTqkbAVb7mrCpTE1VsVUWFGSRYF8+KNAWLzQ7iia/\n" +
                            "W/pXF9Cuiumcvhcffq5jJJlZpcvftUpRNcnetjp3U06kti+0lmd4FDAySsQsfbEhaOMMT8lTvIBi\n" +
                            "Oyx2y+D+vgfoEeBwNkMD6fHpCOAIyq0vYkbElFZuNM34qq7IG+3t1skKo4HqTdJYLqHD5LPw5m3l\n" +
                            "7tF7CPh2u5Grk6i1hbyCRJTkeNczFaSkKLZJci81c2GD46Vw86xXJ/mGnnd41dSrBAAhkLHadirQ\n" +
                            "sCiRRsA3kEmFG0gZ/GiMiuRnm68Z7debeLYhzpl5Oyw0Brxrg7+SSTx8nfpakxw72/wCdEDezzoA\n" +
                            "fBA/20NePVZliSQGMr40Sd7GgSWIPjz3EeCd7/u3sHJjiXY9qnZ3vRPkfsFRr9cePOzz6HZHevYX\n" +
                            "9/8Abt9eqNu/tycXjFY744que/gDpvqY0FVLryR+O1Cka/HW9Ak6PDcnjevJ9GYqLxspjUEbBIPx\n" +
                            "8duweNgaG978aA87FONm/HQYDRB+d+dccb8aI8kHxx6OxFYTGZF0zqeCCVOtFSCAQO7xzrk6HPIV\n" +
                            "NE0QTVH2zj9/QnpwE17jj2yPb7UTX4C9QUwQrrGFI4IGjvfnnevnnY8+QePW9TLKH7zpF38dvaPk\n" +
                            "MxGnI3rfHdsfHPrZnnp0oJr9j346kEMk8qwQTWnKRjuYrXgimsSMAOIoonZtKI1JAHrVx9/pLr3D\n" +
                            "3Ti8pSzeKsLYxd37aYujSFfZt05zGRLBModoponCSxSB0YK6tq4jYqX2OY1ZUeQIWVS2QLNLdWVU\n" +
                            "sLo1x1FiwDi855J5PvX09vr0uZ6tN1ZTuYfp3qejQtRh1uMlWHMtE6gFK+Qrw5Co0VaVtJdrvJDP\n" +
                            "agZ4YLFSQ/cKz9P4HG9L4RKGPxdWtDUqxlquMpLB9zLDCiFkrCR5HdxGFiSSeaQKFjaV+3u9MGA6\n" +
                            "Xq4Wn7FEdtcTNMzOVaWaaUjvaV1Cg/iqRqO0BYo0QD8Roy2OmmsV295YYULmeJYVZ5gykIPdZgYw\n" +
                            "hPf+KEsQF2F4PO5KiGNj8hWLAEKCzYHrKgsxx6FYsEshasklVazz2FeMV+nUXxPTM2c6ws5nIyi3\n" +
                            "jY8bDTlo2cG8WKt1jLamhqCpkIYbNbI1bTC3M8lvLVnQRCSnSn+1lFlMCBNAEDSqBvWgT+I/2PgE\n" +
                            "/wCnA16ORVFbSHR7dEDQXv5I34B348aGuQf1pZ2ePCULl1oksinA8/2aypHK0cYHe25AdpGrd0hj\n" +
                            "SWQKCI4pXKRvxd9Q8a0fSqxxoKArAzQUEsTkkZFAmlHQ2G0Ysg/fA4vz+Z9h0KljVQO4MO7gHXcu\n" +
                            "14J2fH93yACdccnWxFS7xsN3j5BGvx2CCDxogg7B+fO+T6W+iPc60F7KTZi5YrUszKtXH1LFRcei\n" +
                            "Kle7RAt0KVW3cQwTxs0U1uWGwhVrUDBjCtOer7asoXUh+NDTed7P6GwSdbPAGteryRGFzG2HWtwz\n" +
                            "6TQIFmiSLzih2JHXJ6skY8E5rGccHH3H3pW9mN3MYU7U72RpTwDsEEg+QPJ8fz68tV7Sytrej8MO\n" +
                            "4kAhefO9cjfx/qPR6GpsEsv5jZC6AJPghiNAc6A2AfIP87LVvc0SoBHGyN6488EeB8/Ovnz6hbOK\n" +
                            "BrOft7H7cffoT8X34vHArn/P+c8v/WToPqrOZH6adW9G0MHlsz9O+rLPUEuE6gyNvE0Mpj7ODyON\n" +
                            "swVr1SlkDXzEL2oJ8VPZqPVjnjJtSJCzk8/ZL6qdH9ZfV+9m+uMtV6L+n/8A0+YeGznKfVW6cw+q\n" +
                            "3UnvpSrOiJZoZmxgsRSkmxJwtm609m+lrHSWkkIT6FXYH7WWExuw5dCCSQf0PPPOhsc73z6+dH/U\n" +
                            "p9PukOjfqz0v9fOtfpxL1/0MuElwPU2JpQ1vt8b1hBLCvRfVOboXbtbF5SvYhltdOzWMohr0AcZJ\n" +
                            "J9y8VSH1na1GiVpYzY+ZE8qvZSlCgSEKpchCEZlGGVc1RPX0f+BtfpviOqi+C/EUlE0fwr4noPge\n" +
                            "o0Xyhr/m66Vp9RoYRrJ4tD/Ma2GbX6bR6iUxtp9Rq1cHUMsMHXI31c6W/wCoD6mfU+l/1Y/SbpCp\n" +
                            "nej8DVEfR9PrJcViJLHTWIx80dvJTdO5u9j5JsLmpruYvY+0l6HKS15kswxUpEpt6tf/AE6Y/qiv\n" +
                            "0pc6wXoir9P/AKj/AFvxWD6D+mHT1W3kMhL070fj6DXOo+v/AHc9k8nmqmEiNr+rV6eRsymKPF9L\n" +
                            "YOtI8FvGFujer426l6Ux31B+vvUWH6J+kdd8bcx30t6UvLmavUUsohnw9frfqfHxsnUMbyp3R9Md\n" +
                            "NVIME5SKXIZPLV42Crub+l9f6l4h8v1DSwWc+pf1Q7MV0JRimp5fF/RjoHHTuJcnjJqErwR5jD05\n" +
                            "Ht5LK1J/Yu9YWsViKkyVYYpPWZ/Lj5xkVmkke5SGYKSzimkVdrNF8wbUhQszbiCygRZ+lj+IfnfC\n" +
                            "Ivhetj0Oh+H6T+X+Dxz6KKfVwx6b4Y6arTfCtVrP5jTaH42+hdG+JfxD8Q00MOmh0SzabT6h5vja\n" +
                            "rF1ZY6Tx+P6Ux/SmLuXcJjcLjMZj6dnH2EgswVcVDDDEjWJIpNI8MASw47JGUsySxSkSJt+xUtrF\n" +
                            "YRY5onEMscqGOSOdVAlgmR17xInKyI4J0dOvwQE+ogx+H6Rr9KSC19pnKQ6VkyEmXrYqTHUp6LU7\n" +
                            "GUlyt1kja1Wr7lhrJ32btgBY4/bErpt9LdMUuj+lsR07gJb1vG4XH1qtezkrs+Tv2oYIUhjsWb1l\n" +
                            "5JbMzRqvcxbWgI41SJVVfUiEJpIpCzKzSFYowq7dgVQ7mTcCDYVVXZRALAjIP5y1Uxl1EsjOZmkk\n" +
                            "kdpHB3yFm3GRgSTucnc1kkE5JPRaw0SRSySskMUCGSV2KqqRIrF5WdiFCRoO5pGGgASSoUlYtQw0\n" +
                            "/UvXWRz2TrTVf+yVyKljK+Qx1WVo4JKt73Mp01lUn944vqOC1S/qfuV4WFrDmjqzDElhKfk+pcXh\n" +
                            "6t6a+yNcpUzdbGwz1lv2qsjtXgMNWaaAF7Nn/uULMyQy2mWFpFYkghgqOIhoR2cXikxEV+vVnam1\n" +
                            "NKVmGNoUZK1uug1BJWjcx/bDa1mVokAAO4RmgjkbaymVTCjnFA7TILORujO0kAkhv6gNwZdQHNE4\n" +
                            "wSvfFFTmqrx9PtHvqTbwVeitS5nLWOygK3MVQxt67WyuTse59lXqVaeOnr3cjHbsWo6prROoEkkc\n" +
                            "okgaJJky9MU8tR6bwlXPTGzlkowx35TZe2xsBAXRrUsUMtr2t+2bEsSTTGP3Je52dvQizhsf9XOt\n" +
                            "8dnaFqKtjPpzkc7i7FjHZa9RzOUa4Me6QlYcVUsw4hcnimgnFbMmC5LTt07Kl69mulAyr46hbrVL\n" +
                            "V2nUt2kk+2rWLUMM1v2+1ZPYjkdZJ+3vRWEQbtLKD29w7mJwsEGn05Y/NI+bqEcL/oszERorYK7o\n" +
                            "ysrDOXQYZWBsqs+EVmauEtm2gWSVAzQUk8UMnFnoBNGxDLxt9gEaOlJPx8jxo8Dzs8nuDta9tin+\n" +
                            "Ke3ja/kp18gqQOfOgOPHkemKxEQCxHDICDwe7Q4K6JB3oa0edcb1yqyUrXexCMQTsHs7tg8j8i6k\n" +
                            "+fkA/vn0D3/eehki8efv2x38j8b6ssNWXgR/iV1wfBU6IHadHjXBJ487II9F4IwNGRFHaDs6J1vf\n" +
                            "w2yD+jrkb14JG/Srhwnch79nzvkHfaAQeDwd6OvAP6OtmsFkb0dZsVkJKs9O4lgRBnNO8I1kjlo3\n" +
                            "hCVlau6yNtUkBSZImeORYzGytW62Qq8bs0P/ALVmrr2/Pp+gMd8c84q/0HtfPSD1Nmsrkrh6X6Tk\n" +
                            "lW5ZrWCc9h7GJuy4a/TnQNSyNO9TvVqkUyHtks209ztE8VSGS4kUZqPT3TVPEUa9WCBA51Lesle2\n" +
                            "W9ddVFi3KeSWkK9scY0kMKR1oFSCKKNfHSvTkmGoJTlMPeJrMqR1VkWpXimmaZalcybmkjr9xHuS\n" +
                            "kM7M5VI0ZIkb1s0a0qVLNyrDNNPFVhiexFHM9iaN5Ya8cZYO8s0UcsiIAXaON3VSqE+jvMNogiT/\n" +
                            "AE0O5nAt5WoDfIcnaAPSgOxDuYWzEmqqBlsk1z+me/58eOtE1FuQmKtaX2kmeGwa0iOWKBklrSSJ\n" +
                            "3NDLG7Kz+08U8TooLD8lY3BAF9tf7iAo/PuLEDQJLnbE/JLElj57vXjE4HH4ZJY6NZIEsSe9OUXR\n" +
                            "mmACmWTQ08mtKzFe49qhiSOD0cKDRAII2ToADRY63558640N/wA+lyaJ22yj1AkUTYGeTkfU1z2r\n" +
                            "rgduD5qhWOK5rt3v6+wqSp2sJVA7eCvaQD3EcqQdcaGxs8+dn+71B+qelcRe66w81+zYxHstYyz2\n" +
                            "81JLksPlpakJq1qKvPbS3iKtKTLtdiSnk8XVfIwQyNTndI5GrvUuSyfdbw1evJiZJlrWMR1C0F7I\n" +
                            "VJJYP+8WI7lfHwLJXZZkiqitJYAvR2GMZ0kkQIdHdIS4ygmQyrWp79+GVDWtdxjx9OzYe1JUgina\n" +
                            "W0EnlYWJRfns3AWWCR0jhSCJ3TF9Gp1IkKMytGkakbmDp/VZDRkKSeQSpU4V9hEUGPY0bJwOAOOT\n" +
                            "nzjjB6Z8bSqU61arA4EIhAiLPJL3qFB7zPI8skjMDsyPK7vsMzt3b9bs1SIqQV/NV0PJ4P6+SDvf\n" +
                            "OzvyR6WsnVS/crY6KXqDFW6GnpWcbTtx4srKgCNPIIJcPYigEfbJUuEaO0jjPuKS10EuNUg/qPsP\n" +
                            "eCdk8ldHjrySKxCyQpKXkhV1AkMbPIELFRI4UMQFfSrliS3qZSCGAY2GBNhgR3BweR1JpTxQJ9q/\n" +
                            "CrFH98DoV9hpdgbXng7Db38HZ4Oj8k6IHrFJCf7ANBgN/PB5/Wz+vnQO9etbrcyxYGxIuOzeVMck\n" +
                            "TGpgMlaxd5uyQN3m3St07i101/jR1mmeVT2mvKpYAd0PTeasuagrZ3H47JVI+/B9QWb1q3TyNW3a\n" +
                            "gmsQ/wBRlsWY4rUaI6skq17cIrW44Y3lkaQYY79gFkgNYLAjODxtI8+qx4x0wNGr6KTWM5QLIYVX\n" +
                            "bGyM9K2zcJjMrlN7ru03yj8uvm2aG/8AZKx5QdwOt/IBIGvg9vA3wdHjXOhglxqyd6OodT3bjZe8\n" +
                            "FdHYKt+J+B454PpqeBBKPxI4Ojokf7/sfonj/n17dqqpBUAkccb3zsbHBB1yCd/z8+ist9+3jn71\n" +
                            "yfBz+OMsEjgkUbwe/UYl+nPQ+Pknu0+jel616y8rzzxYDFRSzy2STPJNJHUVmksMxMsjsXkY7csS\n" +
                            "d4emOgekelJLdjpnpbA9Nz3gv3TYXF08Z9yEkmmQSrThiRlE1ixKeAHlmeQ7diTUrlQTSdx7vbUf\n" +
                            "j41zwRrXIBB8jYBHI36Wuoc3gsHjZGy1v7dZA1WGGCJprc8rV5plhghi3LLM0MM8sSKO6T2iIwX7\n" +
                            "UNUg3uqpHuYkUFS2BbsoAstVWBk9NP8AEdc0ckb6zVNFIipJG2omZJEjbciupfawVvUoYEBqIANH\n" +
                            "qFdS9B5LOdYwZSXq3qfG28O96fCW4IcMMPHjs9BDSy2BSoHlu25YIsbWsteyUCRVpbUE+Nf7tJzF\n" +
                            "SK+Or0alapRT7erVrxVIIw7ydsMEawwx7cs7ERoFLSMzHXc57iSVf6S9HLicHLkrNfJrcvXb8ME+\n" +
                            "dgWDKvi4Ls0VGWauEVoJL1eOG1OC7tO/t2HIJVUo1mt2FtEKB+hxr/Twf4BGuPnwNDWM+/8AljKJ\n" +
                            "YtNcMZWNI1IUndQWyRvLsLP9TO4CmRgUgbs1VkdznAznufoPGD1zd11jDkuvujIIbHUtHJ07CWq8\n" +
                            "tfFYabpm9RW5Fdy1GfLX8fct0sktbFx2Vhpz1pZoo0SMMJJJ69feKWPkKQCd8b2SdcEH443xr53o\n" +
                            "6JVel+kM/W6n6k6i6su4bJzXFrVcLLjqYherRqT5Aq5WWt93Rns0rFKvkIUyeQr2bFE2q4ppK1f1\n" +
                            "j6zlyMWe6Tr4nqkY15spFFlOn1r4y3Jk8aQ9mWwkdmIX6wgFOSGWxVsQw/b2JmZZrMUCPWcLM2n0\n" +
                            "6PHtggJMu19m4qZnHpjMlAkoNykK9ksqEbbAkWcjI8ewybNg+P1odHqWMxWPsZDI0MbUpXMv7UuU\n" +
                            "nrV44JL8kCvHFPbMSr9xYRHaP3pQZjGFjLlVQCO/WPpXJ9X18NB09bo1M2L0+KhtWZKLxy18rXVr\n" +
                            "mOtY+/jMrBZrBK1bNOYoluocWkUYerZtpJV7udxVW5LjpLQ/qC0JLyUU2bs1ONxFPPUgYA20hkKi\n" +
                            "wsBkkiMkCyKpnhEks6frZaX6i2c3VuYvO4cYYQyTWq9ir1Bi7BsSlKHtRVqePjUiWTT24XzDQq9a\n" +
                            "w6Ronv5UzfMGxizF2VWO71KFAogk36QABX9OOAOtv4R83RTv8SKoh0enl1EKaiB3h1TspjWFgVEZ\n" +
                            "SQO1h2AkCsiB2sAtU6Gk6Xw9XF15pZK0BZxHt2ghknkMksNGM7NShDI0iUKakx0q3t1YgIo1Uaz1\n" +
                            "3ViO1ho60FJ1/wCnP74HPx6f6mVzVrL3cbfwDVsUCz4vNRXa9mKyiQ1nkjuU2EVmhM1ieeOqIVux\n" +
                            "TRVZJZpacjxQSZZqsPuvtFJ7t70vO+QfH6/4+efTSlQoUWAtLkFeKGNwFjjIsVm66w9UZmmMs7pJ\n" +
                            "JqANQzJLHLuMx+YSxjdgj2T8yNiskb+l0Vht6BT5Xra81+rSwLw4qWlLD93Dk6tTKxyyuYltYa2k\n" +
                            "1utc7q7GxC1iLG/azIq+5OzajoP03q4iDpytUxH9QK03+yuplggyn9ToxxV7DZMJ/hG9MI45pp4V\n" +
                            "9u37qWw8nuiRiWC6cxmNrfbUqkdcTRobTwV0rLYm9oK9kRwBIonkYGQiNEjQt+I9btZOnuhcWYxN\n" +
                            "KptXJGRrli5fv5HJPAzkPO/3NuxJ7FXt32sIq8AXQjjAHPKJEbTxIcuhQRhh80qCN0gLtZAugMWS\n" +
                            "T7PgHkkHHP6fXuTxd9+2HqrqXG9NY55ZbHt3JbVPGxrAtaxLSs5F/ar3LcM1ivDFTgJEsstqWCDs\n" +
                            "TTOe4D1vdI18nkpWymYo4gWK33VBL6Uljy8rQziFlmdTPDBCgjfRq2p4bXvK6rWETLMqYz6exdV9\n" +
                            "Qjq/Pz4rNYvJYyl20K2PWPGXpa0jS0rs0dmA3GmqK3soZbktezEIvdqLJEhS7rXCR6SPQ0QANcEa\n" +
                            "54/tO+QNccjn1aX5MESRRnfMw3TOQQEYhP8ASXAbB3BrFcf3A1F3kmgT6RxixROc+eeOsKxhVKkA\n" +
                            "a8D5G/xHwTonj5AJBHg+gWes3cfRaahVS3Mk1dJw7yKsFaaRUntusEck0y1oyZTFEBI6qzBvx16Z\n" +
                            "xTdirEPs6Db3rWiPj+487J/kH9+hcnTVV5bskNqzHLekLyoLEgqNYWCOuGmSuYLDqsUaBqptiJip\n" +
                            "IQFmPpeEqGUv/SDdEEhvULBoihX4nHe+uILVQ5rPejR+mPf7e6p0bkHsZN8Wchka0dCaORKhSxbo\n" +
                            "5ICKQ+3j8xfqfcGvF2CWxTjtWGiX2kE0KGaFnLqPq2HBmtDHj7uVt3LDVFr0E+6kpy/ay2o3u166\n" +
                            "z3o4nhikdZY6csarGWkeMFC5vAY+PDUa1Lcs0VSNY1nkcyyS6Y90rO5YgOzNpd9qgBVAVVARLtSp\n" +
                            "k+v457Amz8WOqWXpt07apJkun7ZFStJBkftbNG+iSJJZeITWZ1m9+RBXj9kktL8nUah2KVFFG7bb\n" +
                            "zJsAAyAv9TEMQzWASAxoKYvYtdz78favb3z9cM30+x1psGlzJxzff25JmlnnyNu+1oGUsbP286Rx\n" +
                            "Y1pJnk//AC6tEErRpGnewUKjXbjgqVpZbDNHGil3lEcr9qjf5dsas/A5btTQXZ4HpkhhCImvyGuS\n" +
                            "R2sO4chh/wCIfPP7159LlnqfE0rU9XNLZwxhldYbl6vL/TbkJ7Sk8WRhjenESW7TXszQWEYHcbLp\n" +
                            "vScs4eR5GpPmMSAbKJdULJFAZAyOwAHHVoYZZ2KwxSTFAGMUVGVl3KG2KAWci87UfaPURtBPUqyt\n" +
                            "HIdQ5BYMXax+SxfuxzpnauctU58OoKrex/sYS5WuXbMvZG9ZZp6kECzy/dyu1eOvYo0FX7WrFWR5\n" +
                            "ZFijRVksSyTzv2ADck8jPJM51y8rPIx5Zj59LmAx/Ty9U28j05M+fnyX3Qsz0aUKY6jFdtR3LdjJ\n" +
                            "5xIRHfsB4oYMfWWWS1DCiwrXEHu2UqEmPRQSV0Na8c7A8ADQIH6PHnY367S0wdz/AFkkEghloHAB\n" +
                            "F97oWxAwSK2q78ZJjOl00e5IEgR1jkieCX5jKodpYpGvf6QvzFihilZWlVGZ3ldQePu7Ng9x0NAH\n" +
                            "QHkjwPH751zr59e0kELoGC7JXt2fCjeuByAf0Rs/+5R6DtJ3Iw7VOu4D8GBG1AUg9ra/uAOvBHJ2\n" +
                            "f403jGmG1+OP2Cd61xrzrk+m+sLd7VxXe78Vz+OMc3XS3PXYdygnXadAHR1z4JGiDvfB+P516h+a\n" +
                            "6C6SgtX8h1Iy2Jc3kUVshcuXazoxlmkoVDLDOiRLWDezWJMaajiXSt2qaN9Tersv0PiIMhi+j891\n" +
                            "a9q5Fj/bwFSK/Pj57TIle5eqSWqZ/pquWS3aWwFp/wCHJOFrNLPA1T1I7dRWlrsizwpJLWsrFKy+\n" +
                            "4oZoZ/baaFnUt7bhJJYye4o7KQ3phRNDGkysyJMzoGjkUSExFCwpSXSiykblAOCLFdTYJHmrFg/l\n" +
                            "Yrx+z1PsbQylGaWpcyLZPGLDE1Ge4IxlKsyajatLPBDFFdqtGBIk86C6kius0tkOjwj87naVLIY7\n" +
                            "DGrkbGQykhWqK9BzTZIo5Zp/dyViStQieOKIn2DZN07Voas6h+1zvwTJXnFL7YWvacwCyH9hZdHs\n" +
                            "EyxsHMW+3u7CGC78/MmoY/qvM9WXLfVGIp0MVirNdsLNQzmRsw3xFRrurzYwtVre9Bkpr0kNuamZ\n" +
                            "RFFDEQ3txWGrEFkLvKVpEJI3JGzsQFUquN/qYFlj9RUM1gW3UNgYHv5Aoj8P3XRfOVclFTsy4l6K\n" +
                            "5FQpgjvRTPUd1kQss/20kUsYli74hMhcwuwnaCwqtXk59ry2c39Vp3wnTWNxvV+CwtX/ALbnO3jY\n" +
                            "qrj8oFXGP05NThNizLfNGxBXyzwVEjq0rVbJYpbLV44+h+uD1THgLk3RsWJnzsKd9eDNQWrFawsa\n" +
                            "yEwrHUt0WaeRvbRC9pEUBy4I0pVOi8BlsZHlsr1PQwFbqLOXYbFqXBR2Oz7eCpBFFWltWS1mYQzi\n" +
                            "1KiMfZhaeT2eGZiWF0h088rGJ3kR4Y03sJLcwhjJGCBJB8veyg3UoRtwCsr9k7RkcE47D3JOSa9w\n" +
                            "Lv2R+v8A6X4nqM270zTC5ZpzVvbsT2hTWSeKKqbdeSq8V3GXUqo8MVnHWa/YJ52aOVppu/SrYjIw\n" +
                            "YuLF5C3cBLIyzwZOW1PXFeZJaojyb1KVmwIzFGS1yCSSX847UlmMsZLbbVZQQyd6vvg8FSP8wccc\n" +
                            "/IJ1scnfHpbsU+G7ANE8LvY88MRwOda0uuPII16y1RAS+wWwIbzZz6q977+enZPiOreGHTvM7R6d\n" +
                            "1aAMdxhKgD0E4C4XkEjaoBoV0t46xFi69eo800yxqf8AvFqV7U8juztI8srgsZHdy2hqJAeyNEjV\n" +
                            "VGGW1XeR2Wawqk8AFQBrggAgEDYOt8+sGarlIJGUAcHgEqQT443sAb5XyNgfHrmTK/UXqmpkrtXE\n" +
                            "dPXcvQq2JK0WQhsFI55YG9q2qK8LNqC2k9bfcwYwllJUg+iJFJKaj2+kC9zKoAsAAFmUX4W7IBrg\n" +
                            "9IOSzM7WzOxZmwSzFgSaocknNZNXQJv6ANJ9nSsWmlhiEMEsg92RYovcRT2CR2IVELdqFuAO7+AT\n" +
                            "LKfS+c6qHSlfrmGPKXXsQ5eW5i5oo8FWWGsXnakqRRZTHWFeWGrVkhyFlrIkcy2HiMievPX+Ey3V\n" +
                            "i4bF0rWJFOXIw5bGRyxvdpZazia8tn+mdQ1u4xTYS2pbvmrhpYbAqSBQ6J32zoTDDB9MYbEzVa9S\n" +
                            "elUVZ69SV7NeKeR3lsJVmkihkaqJpHMCNHH7cISMKAg2RGGl06ypIh1Ekn9AUiSFArqHWQMGFsfU\n" +
                            "oWvSCTYHWvsBP/6is3dnHbHtX5VfTvUh7BFXCqiiMRp2jtVVAIUBdeBrQ1xrx/BWGqIl5O9nfI3+\n" +
                            "XydHx+tjj+fXrVUMVJA2utd3JUfobHxxxzvWt/Hrct46zeqTx1bs2OsSIRBbhjgmkgfYIZYrCSwS\n" +
                            "DwSkiFdHWwdekBkizVnJNmgTyasmhzV+19DbzXGRmq+/6+egOZzsOGmoV5YoLAtSOrRi/Vr3e4IX\n" +
                            "T7eraMSWGftf8DYgfSExiVtqPfp3F1Ial2athThq97KWb5qy6W1alsdjWL1qNJJVimsziRvaEh1E\n" +
                            "EZgrOyJhxXRt9c5ayWakq5SrNTSnKtjHwj76z2V4/vjCJJoqvtww+wwRVMxZj2RLGPc/uuMtT+nf\n" +
                            "R97JUIlpxwzxLCWqWclVqS2pVRrNmpDYisGjAgMk6V5VMcQLRpx2+n1jR2h02nYyTTGJCyl9rO7D\n" +
                            "atWP6CQBaE14bHVBfLcC+RfiqP8Azn3Jvpe6mzt2zXyOFw9Cjblr23q5mC7kZMdLXwZrxGfIQyR1\n" +
                            "rJFp5LUQx0DJ7doRTASBlZEeulunXw8VizdtC/lsi8cl+8teKsrpDH7dWCOGGONQleHahmX3JJGk\n" +
                            "lcKX7FVugsRkepKf/aXrfpXGYnqM23SrJXUFrOLryl8bO4E8zugLvLVS6FsRCT3DXrSOy+q6sagE\n" +
                            "NoFSeR5J/Xg/PjfP/vbVARA6VNlo1TOjrIsjDbe2RWIZNy2Cu0MQN1lQQIt5sk8DueL+48dJ3VHU\n" +
                            "Nvp96FiPHpZx00lgZOyPuHakkcQeDVetDLNIJ3DxyWAhjqkK0y9jlkznqjDzvg1pWKeTOeyYxdf7\n" +
                            "S5A/Z207eQsTMELlhVr03M0WlZNhT2k8iOtvpdhOuruGuZaW6lrCSPNi561mSFqdmR4pBbgjJNdb\n" +
                            "a+0qpPLBM8SEiLsYhvWW39IukbuWp5uerI9+pKZ9yGGdZZGiMUsndYgllrPNGWWV6M1R3VmXfazK\n" +
                            "c2tQHfYqlCybQWo1gMRSnOOCDZN7v7Ru6c/w6+m0f83Nq49UsWs/mBBpWZDJbHSLIW1S/MDWhaWI\n" +
                            "wqip8poGJOoNCYJVgZ3KRpEpZjwNIgJJPH9oAP8AwD/PrCb+PatBbNuslWw1eOCdpo1isS3HSOsk\n" +
                            "TsQsr2ZJESFU2ZWZVQMWAPvcqLbqvRR5IBJC0HuV5GjniDIUDxuNsjxg7WQfkrBSNn0sdP8A0z6e\n" +
                            "wa0WCZHKS4x3mozZjL5HJipMzyMstWnZsPj60kIlaGCWvVieGMBI2XklgmRSoUDbVklitH00KCmx\n" +
                            "z3HFYvrEiGiMcr6jUahJVdRFFFAkolQq5YvI80fyirCJRSy4dm2HaATWSnqYilcyF6WOtRpV5rly\n" +
                            "w4YpBWrxtNPOwVWYrHGjuwVGIA4X49a1a1Qy1Cpk8XPHex9+pBdoXazCWG1VswrNBPDID2NHNG6y\n" +
                            "I3cAykcjZ9ZuounKvUESVcjJkVrozMyUMpkcWJ1liaOSKw2Ps1msQtGxDQTl4z/d2hhv0i47pzNd\n" +
                            "F2Xj6cVH6Nx+KirYvo+OWSWcTIEQfY3cjKVxsEESsIaccz1pR+JjgYBvV90vzEARTG5C2GAYMxFM\n" +
                            "26lCKN24lrXnI4tFF8Pk0UrNqpYdejfMVJIx/KSwKpVoVdC83827lDHcYhKlt8ibVdsy5Ge7matR\n" +
                            "fvcekUF03cTdwdv3p5Q0IgsRZlHfGrXhVZdpDJY+5MyD3YWjZHITx9vcvbpe07HwCDsD9+Nfrxx+\n" +
                            "/S5gsTmI7+TMdvqrHH7n+oFs5fqZqpd/qFiaaSklUB4qP2capGseMtRLFDJB3SyS+6pd7EIJJYbJ\n" +
                            "UnYOvHkaHHJ41xv9+mtSqo4WNlICrdEZumNMoNglsep2ApS1gL1nq5HOR+nUd68yVzDYWxZxYpJl\n" +
                            "55YKeNOQYx0jatSiNDYk4jRe3uKe9LXhkm9uJ54hIHC9GvXmNu4qKxBjs1Rvy11ybV68NGxivcRf\n" +
                            "uphK98rPFDKxlj9qrZknVDAVgLLP6KdaYDLZLMoZ8RF1H0/9tXiOMsNiTWRmlsLko7NLJxhLBtwN\n" +
                            "VavZjsI9d4XQxMrkMzX7cWJw5yMtK2kFGpHJLSpV/vLkUUaIGjhq1GkM7V1BJjqmQsqMIRI3ajWD\n" +
                            "BIYURYZnkZi1gM4LhRGlhhIhQgkClG42CwoDt1m+KzWaqxXnPmh2B6DZLIUMZJjq9uYpPlb/ANhj\n" +
                            "oVhlmls2nhmssoSJGKxxVoJrE8z9kUUMDyOwUbPpbqgo4ZCSF2Cm/kAeAD4Hxo65/gmTdGvg/qX1\n" +
                            "xJ9QqUebs4bBxN/2UyVzMrJjXt36kuNzLUsJFbmajDLWihCpkqla7HOs8oSFbBja22F7kZVbxvfb\n" +
                            "5G98EeCP1r/29RqNMNO0cRLmVYw2oVgFEcrZMIpibjQqH3U3zfmKVXbZnfYJx7c54s+4zjxn36RX\n" +
                            "2pCP3AOpC7U9vG9bYLx+/wDXwP3ozQlVLAhlAJY6OxrfP70CTyNgjwONlmtRdidvYDoE7J4HnZ/j\n" +
                            "j/L+/I3z6X7DNtghCjldH+f50AeP54BIA9LPQ4oXyPPjqlk1+ArH0GPy6jX1LyzUMIUrKGyuRnhx\n" +
                            "eH7NlzevEqsx0CGjpQie/Oh/E16soJUEn1MsfQgxdKrj68QMVSFIVYrGWcqPylcse5pJXLSSMdln\n" +
                            "ZmJJOyz9WzLlOspONUulKfa/khs3mIgZONdjPQxSR6KnuX+qyrs/kEUbE0vvSdskBXuOiw/LX87P\n" +
                            "/wBfHHrpBtSNAMkCR8kG2HoFjkBCGHguRZ6sl5N+AKrjF3YPH5/Xrs7E4DE05zap0IYZJYyvuRoU\n" +
                            "ZVdgzKgI1GjN2s4jVA7IC42oPqg1VCBGKntKgEE86I5AIA40ND454HHrHWrBtFAo0o0SB5AHB3vW\n" +
                            "/wCOT88D1v8AYy6BXuC67wAD/bs7Gv8AngHjjZ+FCS5G4ljgCzfGBz462d1cAVQOPNLf5G/2ejFZ\n" +
                            "gHBI2O3e97A1ofI4O9eNAn5PrSxPWFDLZBsXiKmRvz1r9mlaaKIVYq0tEwtYksPaeB/tQ03spLHE\n" +
                            "6zyI8cSyLpmQf/vExeVv3unMKLdbLjFz3aM1irNAltorDU0NFGieSzGtpRHLIY0j1yhdTs0zoTGZ\n" +
                            "HHQXZ8zo5XJWYrNspLHLAWjrRwqYFiqVBGSqf4gKM7upkaRtgDQXSiGJpNQhEhVTChJUndXrIo7l\n" +
                            "As2GBBFVnFDk4/AA4vx9z+PHVAlaCrWmnsTRVoIVaaaaxKkUMKBfzeSSQqiIo2WZ2VQBskfMof8A\n" +
                            "7SdVdUZDEJewknRsuDeGyKkX9TWx9xZ9ty9xQkda5LTaSEU3ezDLH32R7fb7chbr3NvNTu4HE5PE\n" +
                            "x5qvUgv2sNmaaWqGUxViSWtJBZExjJib25ZG+1lNkGAKI3WQAu/RuKixHT9GukElYSQw2mpPPLPF\n" +
                            "QexEkktOq0+pY6schYRQNxGNqoQaUciDSwHUEK0spMcSOuY1IVvnAOo9VH/TdNy5JtWUAiYgkAHH\n" +
                            "f8vev2eidbHwVa8VatEsNeCJYYYYgI0jiRQqRoF0FRVARVHC6A/EaA8yVwoGlHOxvz5Og3H78eAP\n" +
                            "P+2ld6t6dxl8Y+9b+2l7UaaxJFIKFdpAxihuXghq1Jp1RngjsSRmReVJ7lDMOPvYbJuY6OSx9yXt\n" +
                            "L+3VuQWGEYKguUikchdlR3a0Cw35HrPWZWYguCbz6hdmu3J8+4J56vJpNUkQlbTzrE6b0lMTiNkP\n" +
                            "DByu0qbGQaIIzkdD4YWHadjQHhjvY4I18qSf/ngeskkQZWKEgc9p3rnfI/fkkbGtfOtg+jstEKAV\n" +
                            "Xn58jwB5/nnjXyf160WrlEJI0N8DWzvWyDsb8/rjfPk+iBhyWx4r87H5+Djx0iQQc/vv/v1oR1uz\n" +
                            "TEASAeR8A/yPnWhv+P8AjJyGB7vIBIH+bYI1+vOh48eD5JnN7r1MN1tF07mpcdQxluFpal6b34lR\n" +
                            "VrNIz28i5/p9Z/uIzAlWf2nkSWOWKRysi+qYjpMiuGSWJlDpLE6ssikBlZJFJDBwdqVJBB2G536Y\n" +
                            "khkiWNnWllQSRtyGUkjB4sEEEdiKPQWo2c33BA9hz9fH6dYG5JJQADQYEb7j+j/t8Efx+h6mWfz0\n" +
                            "l3I4/F4nDZzJ/a5OOXKPjr0WKkpGm/uJDcjtGF56llR7yLJJXpX409mOxKWkhNZURBHO9gLvknkc\n" +
                            "jnfg718geoDjcjkc7142Yp9LZivcx8P2L+91EqUBjLNpa9j+oYnsrpBci9lrdeAtfOwJa5/xJG9N\n" +
                            "6GPf86RlUrBEzgtIqKJCCqbgZI3IJPMbWpFkEEg1s4FkccD6eBn27+OqyqPNDHI9eStIyBjDL7Rk\n" +
                            "jJB0shheWLuHPd2SOgJIB+fQu3GF3rwQSRv8jof2gDzxo/Gv0dbLLZCkgAgHRB+P9v0DyOfH+m/U\n" +
                            "W6nFq91UMQ1PGdS1TirEqYt1pV7GGk7qcf3k12xJM7SWjKQsMdbaxJE+hstIGCETSMCwUKhkNnO0\n" +
                            "DItiFsD/ANmUG63WQps1UPp4549zR8nvXjonjsxSz0U89GC6a0Mj1xYs07FNJZ4ZZYbEUSW1hnkN\n" +
                            "aaNo5nWL2hIOxHdlftj31T6ogxWMmxsFbLz25JkWdKa5rHTpXMUjixj8rTrrA00Vk1UdWse0I5Jf\n" +
                            "dSXsaB7Z0303W6Y6eoYWpEY4aiSMVPtELLZlkszncMcUR3PNIdoiBv7iA29zTqfo7O2ep06mweYw\n" +
                            "qWIq9aA4zL4mxZUrWNgK0OSpZGtZpiZbVmOZBVs15gYy8DPAjemIP5RNWx3ExRFmh3l1MhUgRhyi\n" +
                            "vsLiiSBSmrIA6GbrsePp2vzX7Ht0H+m3SB6T6PxWKnf37UddyLMoie6KU881mlSu246tM3ZaMNj7\n" +
                            "dpzXiDFWIjHJZqKmIujEEd55PjXj+fjnwP41o+mIdxjQT9glCKXCEtGrFQWVGYK3YG/tLKD2gEgE\n" +
                            "6Aa6AAxAPj/KNgaHB4+P55H/ACT6XlkeaWWZzbyOztjG5juOPFt+HUjAHt+/3jpduANvej58DW9n\n" +
                            "QOgf155/352J31FkavTuJyuYyEqrTxNK5krcjMFVK1OCSxIe4kDhEP8AcwG/x3yD6eLEruXHG1Yg\n" +
                            "c8MN+ByfO/OyB+iDxzp9bvuupKuK+nlCf2H6pme3m5/a90VemcGYbuQ74zJGrrk75xmHeJ2Cz179\n" +
                            "sa1GxC4NsCwJFgsBQJUZNcCyOCej6eNZZkR22ISDI4F/LjUgyOVr1EICQBZJwASQOubYsf8AUDqq\n" +
                            "hYzr9W2ej8flLpzFGjjsZSku5JrksNye1mpclBPPFWmkWWrUq0ZKcgxZrl5kkXsTJInWSOyiz09O\n" +
                            "FIHutTyaM/A2zKmRdQd8HTEHW9DegJ69z/XtKeRrU0lHHYyKxYbIdHDG3J1pKV7Tk+mc9DLMYYo0\n" +
                            "f88XfllJR/bjAftCpU+qmKWtCL3VuPNrsBlNjpDP4+chiWjaanI8jQyNEULgOUckyR6jdQEvnoZZ\n" +
                            "GkZw7G2LNtUktgKpbCi6XaNoXAOL69bPo9fqYopdHp/h02kU/K0+n0mh/mpYECxhG1Wo0ujLSSyI\n" +
                            "iM7amb57OzFoowSF+zlZI+5TxwDsbO/GuR4P/v5HjYPVoo5oyUfvHc2mBHaCNgqCDs6IIYfGiDzs\n" +
                            "+k/Nrc/pN00orclgQ9sEVExxW5mZgohhmkBSu0oPY1hhuFGaVSGUH1v9B4rI4eG7Ut1YquOmeC7Q\n" +
                            "gismx9nYso/9RpNI/wCUojmRZhKAFeWeZgo36NtHymkLqCGoISAW4us3fqFemiA2QRRyT4qwefbg\n" +
                            "XZwMe3+/W7J0lgpJffkxVNLDMzpdrwLBdjkk2zMlqAR2I27iWPbIF3vgg+mHp2DI06xr5Cy9v27N\n" +
                            "gVJpn9yy1HuH2y2Ze1DJMo7i0h2xHaGZ2UsTCwgkkjg+N/8Ah/nx8ga3z+iRv1uJAqhe0je9fx/P\n" +
                            "/wBA7+Drfq6zOU2MWYYIDHcV4wtmx71+GOhEjtgf5oVzkf56ib/TGOn1TY6yvwzZp7sjVLr1LGRk\n" +
                            "ysFYWZ7WOykEbWCi2MY8v2Yq04xEarFxG7g+rXRydzGdLf1LNNIZqsNhiZ0WCzZjjsSJj1miGlS7\n" +
                            "bi+3R4uN2pChAbQ9boURaYHweefHPPPOhxvg/wDr64k/6r/rrgOnM50R9NJupnwYylw5Pqi5QsmC\n" +
                            "7iaBrWoen7Tyof8Au8ZzkcNqX3SI/ZrdzjtYEx8T+KN/KrJqGDmIJHGSaIGESNb9KgbhuIA9KDFL\n" +
                            "jc/hX+HNV/FPx3SfCNIjsZBLqNQyRtI0Wk0sTajUOEUWWMaGOJcFpnjjHqZb7g6dwhgxh/qUSy5D\n" +
                            "JO+QypcBx91YCl4NN3Aw1YwlWBdkLFEugCT6xdPYqhaz8+co0YIKuOhmxFGavDHCl2SSSN8naJjj\n" +
                            "TvSKWGGpBISQzRWGQ9pBPz5/6eOv/rJ1J1tW6VXqvIdUdM2o7CtnZbEcorVqCR/1O0bEsV1JwJbC\n" +
                            "V6q1pa7F5K7+4wWUD6jUKkFClXqVYxHFWRIokHJ7UUKO4nZYkjuZuSzEkjZ5zNFqU1kSukbIkbBS\n" +
                            "Hq2cBWwVNEAmywOTXv1s/wAY/wAO67+DPiE+i1mv0ur1XxHTiWI6F5Fjj0UjFGM0LqrQSMIzpooH\n" +
                            "B2QiU0P9I9bLKe0+dnwNbBBIPnn4/Xj+ONInU2dkxd3HY5KF+4uTgyJnt46B7cuJFaOL2bc9GFWn\n" +
                            "lrvLMI2eLuZXCgI+yVfe4k/kmiB/sfA2fH/oD/PoTbjpU5LeanQe7FSMTOW2TXhZ5lhjBOgZJDwB\n" +
                            "ou5QEnQ9akBQSDem8UQF4tiNqGxkUxDdwSACCDXXzt+T9sY8C7/L6+cdQLF1b96avSxd6rlqUsle\n" +
                            "TqARxi1RWL30r2YLyZVHuretQx2HkqKlUwMsbGNg3NhjrR1oUhgVI4YUSNIowsccUaKVVERQqoqI\n" +
                            "AAqjS60Nevbp7B/ZU7NuWvHWvZm5Nlr6RqFIns6EcbHtUs1aBYoGLbJZWbuOz6Iz1klR4mAdHRld\n" +
                            "G5VlYEMpVthgRvYOwR449N6iUSPtUUiYsUGY4DE1SmjYU0PSBjwMKBk1f6fT/PPU56ixeL67wGRw\n" +
                            "UGQRqliVqF5ozMxheGQCavLHFNWclf8A+1K3tv3BmV1POp/Q8h0PhYTgcpksjRxNWGBMTmnfKvch\n" +
                            "gjSJYYMgynJxWZFXULyzWYvdIEkQRmYPUGOp46IVqkEVWBCzLDEixoGZiWbsGhsts7+Tv9j16CWS\n" +
                            "PQLFk7uVI3rXOtt+/H7/APP1yalkX5Kktp/mb/lOFIYkBWJx/UQoAIyoJog56owHtn64FCvbj9eO\n" +
                            "OsLLHKofRjYqGZX/ALk7gC2zsa8kb3oEHyPUzyv026eyMsN9ZcrDPFkxmI7FLM34iZnlE0ykCZ45\n" +
                            "K9k6EsZBBjVEjaNVQA91rmoMTg8hdmjmlRoxVEdWOeadmt7rqI4aqvblfbk+3WilnOiY0bt16x9I\n" +
                            "y5F+msUMpagt2RASlivDPXSWqXb7ISQWY4p0nWqYUnEsMRaZXJQEn1MbTQxnURyNFuf5Q2kjeAtk\n" +
                            "YFELgNu/9hQNnqvJok8YNWKoc1xY9vqOt6z3KB3b12/kp8HfO9AH/T/TfHpUt1oXtfeJFGJvYav7\n" +
                            "viT2mcSGMnjaLIu17h+JLa13NtBz+e6py3XWR6Lo+8lKJK7/ANSwvtA0cdcq1TeizZvMVrZDvdpM\n" +
                            "TPSPuNC0moS6Oy0+SuI4/aZCWjGgxLHYA8lvJY/IOyeT8+iSQPAsJdkJmiWUKpsqkiqy764LXe3F\n" +
                            "VxwTHQJwdN+wPB52fnXHz/P79Kdl3LtH+Sb7x3DjX6IJ/nYI52eN6Hr1fqmG11FkOna6xrJj6EF5\n" +
                            "7MliMPZE0rIy0qwBazDX7DFZsCQCGwywtGT2s2edVcNIrMCdEhhtfJ0da4P750Nf8BlRkA3DaWVW\n" +
                            "ANZVgCpPNAg2OCD4PVN2TzQ5OP3n257DwqXHAkbuZeBo/oEb5+OeDvjjfk69cWdcWIuocT9SvqFa\n" +
                            "yWcx1DG2ziOmrXTtqOnk2xHQ0882ReCYhoZq2X6jbIpPBP8A4FunUqrMvYBvpT6r5m1geks1kMWA\n" +
                            "2VeBMfiIyARLmsrMmNxaa470++twPKAQPbRySoGxy99Q6OS6P6bwWBwXUeMoU8Zi6eMbH56lWkxe\n" +
                            "RsJD2TSvNFLTuQ2b8olln1POskkjMK5bYYLqBp5GolnGwAbaAJBLZK5Fri7ILAZodavwtgk8T/Mj\n" +
                            "jdp49hf5hVo4WSV4rignKtK3y40do2UesPSknrjXqd85l/6iWuYhepL1ypYW3cv08H1Fbxt2rVqv\n" +
                            "SgkrNZwmdxmTopJXi9mWlBHfLSmOOxEreqFJ9TKNdzBZ6W6wqzwhY5K//Z2e2IyihQFs0ms1ZkZQ\n" +
                            "HSSCaRCrDkHahczUlqliXxGR6G+2xqmNHu9H262XX2EtLZ9uKpcjp5OCszAsI6yWHrqR7PIBHpJ9\n" +
                            "U+jO8iXqCCrKNCSvcr3atqFgAGSevPXSWJwRyrqCRojakE5cKbGb/UCkhb+YOSCbwwBJyLazY5wB\n" +
                            "1674rqn+IQaVB8KfWRaeWYR//HSqRCjR6REUtom1MMUTCM/L0jIracozB2eWUn7wYObJXDJLkKUN\n" +
                            "GMCNa8AnFixxsyPLJGBCASVWNE2RpizHYHpqhgC/iD+PnW/23/n+t/scHzoHVkSCNpptJFHEXcng\n" +
                            "KqjbP5PAUEkck8j9+jaSvLDJ9uQHaEmGVl7kDlSY2IB/JdldjjY/fksBg5OAucAXQGK5JJyLskm/\n" +
                            "r15xj6eT2rzWOfzu7yR7DofY6rxuOtTVr1XK14q0saSZB8ZZbHIHVXVjbRCvYCwV5QpjjYEMwAJ9\n" +
                            "OUYjkRXV1ZG0wZT3KUIBVlYb2rDlSp14Pxv0mU7WYysUeMyeDas7o0OStmaCXHyQsjJKavY7TubA\n" +
                            "4WKSJREGbuYlRt0p0oqVKtUhH/d6sEVaFGYuwigRY4wWYlmIVFBLEn+STv0xIqKqBcSDDbXEisKF\n" +
                            "MCvBJBxZwRwRkJNdwPr9v0/D3x1q3pXr1p5lR52iiklWGPmSUohYRouwO5iCqAEbJHI8j88n1xyG\n" +
                            "X676j6r6ky9aWvmc71HkWyVOwLn9UxOLw9hsbj8D9kIiqpBXhMsk8cprs/fIWJLAforlQOmtaJ0A\n" +
                            "ONeCONa4+NjkceB6lXXP0l6E6tw8tXqDpOPJRxO09V8bClfM1bDsXaxjr0MlexBYLMzMwnHf3MHD\n" +
                            "AkHG+KaCT4hEsccgQqSwUgbWY0BbCttCxdEeomrqvqP/AIp/8g/Dv/HvxbV67W/CH+IDXR6bTnUw\n" +
                            "Sqk+k00btLMqRuNsyzSfIkeMvCS2mj9YG4Nyt/8AZqdBVsB0Z1f1g0dh/wCqZlMBhpppZfaOKxkE\n" +
                            "Vm40MDkCN5cnakhsOFBZqiIfxjHr6gPKNgjwOQNjxyP2P5/nf75Jgv0ixHSnRfT0HQvS9bK42PEG\n" +
                            "zdkx+dWQZdzkbk1me7NLIWFsT2JnDzxu4BKqxUlAa47l43XuZe5WXuXhhsEdyHztRzx4PpnQ6NtD\n" +
                            "pYdNIKdFuQjILudzMD/cLNA9wLGOvMf+Qf4nX+MP4w+OfxBEJF0+u1VaKKUBZI9Fp4o9PpUdFLKj\n" +
                            "mCJHkVSVEjtRN2RHWOWyNLGTX8BkaC5XFMLDYu5Mhq3o5CkLV7wj7rVcASCWOaFQ6Ov9sgYj1khp\n" +
                            "37M+NoZG89y26xZbMe3pKkaVyor06sSoqmB7ZBLODJKkBkbXdoc9YzDjM5e1i5UxmVx1zNWUkb7S\n" +
                            "a/YrU6x9qabMNkK0TRSzSwsZGr3EMbdhjWQHu9dGdK144as1yBSIZ5BXpruRimPpg16qakZm0e2W\n" +
                            "QHuJIcEk8a9BPHHpYVRXV3A37vlKrf6irtUncW9Db2AObq2K0B4ckk2fP7r7D/PTc5/HsLeNkA+R\n" +
                            "rjQO9n9b/wBP59LV23i7r3cFDna9HLGAEx1rlVcrUWYf4c8deUvICQGEUjQuhIPDdp9FJp2A4GmH\n" +
                            "Pdz4/njXjXOxvz5GvUP6lr4Tqj6h4DGXMfhDkMW8WShvTI9nJW4a8cj3KAWBAtZI9xOv3cvtltPC\n" +
                            "Pd7AV9LEskjh2dRHE8hdUVq2DcCyMVVl3GmAIYA3RAN1JoduRzxyL7jqpRVJalWKvZuzZCVFYNbs\n" +
                            "pCk0xLdwZ0rxwxqdEL+CKNDZ35AzJ246OPv3nimnWpVsWjDXTvnlSCJpWSBGKh5ZOwrGpKguQCw8\n" +
                            "g9aAQKoA7V0ABrwOABv9HgaOyPj0KmkHYQAD/lII40Rr+R++NngfPwHcCdzVn1EUFBF5GAAOe3F9\n" +
                            "dV12NfWuL+/v1z9n8pby/UWAtdO5ylHDksY0E9TIWLyJVltQyPUCQVBLUGUZrJf2bJimV6ccSSkM\n" +
                            "y+qus32VeNHkeX7eELJIVLPIY0/N+1dszuVLEDbEngn5yWcZjRHDEKdaOKtZjuQpBEkMa2Yj3JN2\n" +
                            "xKi96E+SN70T4BE6+p3UE3T3SWVyFVVewY4aiki3I8aXZ4qUs8cVGOS3JLXWwZUWFQ5ZVAYHW3C3\n" +
                            "80+m08SlfUIlB27iXeltgFsgEDPYcnoZXaDweKPiiOx8/euO/QD6W3anUmf676sqZTJ5StNlYcVV\n" +
                            "kyJtU/tBVjNmfFDFySewoxktoJDeEEVmWKZoZS/sDTb1/dy1Xp3LjBV6dnK/0+19st28+Mh7nhlV\n" +
                            "ZPvkgsCB4mKsjsgQMPydB+XpU+mWQoT9KUo6c2KW3XiH9SOHr26leS3KTIbpgvwwXe64o955J0Yv\n" +
                            "J7iiRuw9ss64+p3UNPIZyu46NzHRVWtFWnmrWLF/LV3kL1MjVyWPozyWDCSWDvWrzSRKVBryHvCO\n" +
                            "FJNT8RkEaBVgEarHMa3JAI4kT0iMF5KBCjYWsqtGuhXtF+fPv5F2aHaycdaf0a6fw7VL3UUeIuYv\n" +
                            "NWIKuNzFibqs9WYzJ3IYYZ71/EWWmmSqs9o99wVRXgltGTvieSMyerRMVUMAdjQHk/26OvJ+Nnnj\n" +
                            "yefHpd6HwVDp3o7EYrHPE1SGGWzCtetPUgjW9ZlvGGvWtasQwQNYMUUUwWZY1AZEI7BnymQjrwTS\n" +
                            "TSLHHGjSNKToJGgLMXJJ/EAEtsa1scDYIdfqP5rWzyKWdTKVjLFywjQhUBWR3YWAKUu+y9qkgV1Q\n" +
                            "D0nkYurodrP+LFcHv1F+t4oOoOtemunS5atgoLfWeVRC69ssQkxmAjZl/EMbdi5dXu578fHINMAf\n" +
                            "Xzi+qdXrDqHFZ6Wj1ZUyWAt5DJ0osT1nBFM9CjRyk9QCrm4THMk7pA4V8jBeVGdO0oVJ9d94G21q\n" +
                            "frjrCfvM+WsVqlf3D+UGOx1ctUrL50qi37sgUkNIzseeTwF1R0fikymQN6/cy2POSyN6hib/ALT4\n" +
                            "3H2clcs3LL/aRRRR3HE9mUQy31sPFF2xprQ9ZmvQ2qICQgdGpyg3+kMSRyoYMoFEH0kgcj1XwvVa\n" +
                            "f4buDSpFMg+G6lTJo49YXIEmomjjSQBYZhJLp0EvzYmWOOXbIWIjedYPqbprG2DjRjLXTOQvRosV\n" +
                            "Sxbkt4u4qju1hrwnlxsy9xJEcH28xDE/b9vjat5eitiUT/bmUEdxeKNmO1BXZIYn8SPk8frx6GS4\n" +
                            "3G4ijBjoI1lhqyzWYROEkaGWWeWdniBGolR3kEKRgCJAqIQBzBMnFks3kbuSrzhYJrU8UQBkAKU5\n" +
                            "GpBgFOtP9v3ggkENsE736R3NGqrQJ8AVQoXYAo0cWKsdr6sItL8U1s8w1E+niA9eonkeUSyfMAi2\n" +
                            "CRzLGHiUt8uSadlKGpWBFfqUt348fj7F+xGXiq13mmjQhmYIpLIobgsx4G+NkbIHhOzXXctCl7Fm\n" +
                            "G10vm7IkmxAt10ylK9LWUSmvJJTEqosq6WUSfb+0HHbL3EEbGQyUlxM9gDEiW/6a8uMRpCHyCy1X\n" +
                            "JePu7VPs2dQuoYshCu2g2/S30uvUHW2Ux2VzVJsbjKVGWvJVWNkaxL7sPdC87SSCzG80DMxhSJAi\n" +
                            "Ad57tetDSxRoGlnVdkZ3NbgMQUDRKincr72BVwUIxt3K3KLE5Ax7dhxn/civz6vPTte2lEWsja+5\n" +
                            "uX+21MqxGKCv7kcZFWvHt2SKEAjuZi7sWZtEkFfzudxjz28HeXM1bMMiNR/p0eQWW93Qh0kq2aaN\n" +
                            "GD7jPEVmlQBoyXAX0S6lzUuC6cyWRhjkexVqSSV1jqy3D7wQ+yTXrgyyR+5294j2e3Z/XpE+n/1R\n" +
                            "q9dw4q4y08PJarAvVtySLZvWu0JJFTinhr9gjmWQNGS8v4hAAVc+pgimlSXVrEWijcKzIwT5bkb0\n" +
                            "wFJIIVhSqcXZAz0JyKGT5GOffjx489UzpWDL1af2+Ystd7XD1J5wGurVkjVhBedQY57ED90fvDmQ\n" +
                            "AFx3An0UytnMUzHLjMVBlUbYsRNeFGZSSNPG00UkDrrferMrb/t8etHMZ2r09jbGTuQ3Ja9YIZUo\n" +
                            "VZLlhI2dUaUQQgyOkY/OTsVmRAzabXpA6Pv2utaeRy2I6ueTBZPLTSjHioDfoVe9AtVZpnWxRaxH\n" +
                            "H7jQzQkwrKGjXTktKRNKJdU6qsSuqsxST5ZdiPR/pCwxW2AJUHOehE8YJv8AL6/vPVXx1JpZK+Ty\n" +
                            "NaCPKpXngAruXFevZkSX7Uzdo94p7aEsR29/cU4P5FLtWW1WkhrXZKMzAe3ZijimeJgwIYRzK0bg\n" +
                            "6IZSNFT8b2cQl7AI1A7SO3e+dDWx+vA8k/8AsPS+vUcsnUE+ChxVtpKsdexNdkkrx0zWnDMJIm9w\n" +
                            "zSlXX22RYl02lLDegBQ7ksoB2DfWNqqCOzEjaCRg3d5uz1xrg9+Oc8eK7ni+Pv0Kq4vPYM5Sray1\n" +
                            "PIf9oLqDHyR0jTsV7VlFitO8UTyQmMRxtYZ07dS8lQD6p9WL7OtBVTmKCKOJB/mIiTsDHQUEkAMT\n" +
                            "rkkk8elaq65PNS2gvdXxPdUg3ohrsqqbci+D/hRdkGiCCWYj+TuQuS161l68S2bEUEsleAME9+VI\n" +
                            "2McXcRpe+RQpbWl7jsHQ2WWR5CikruYKWICoNxChboACgBZoUSb6CAQLr6E5/Xk/8/bR6izlLDY+\n" +
                            "Wzbnrx7WQVknnWD7icRl1rxuQzdzlSNqjdgJYggE+oT0QnX1KHIdQYa5gOosBlLZyGGxd+7LNlK9\n" +
                            "acu96nX6kjhVHjW4GWrFbrTpAqNF73tmMR60vUfX/VzYdLfR9npyxjcnWkbLLWGRhWaYdlmmaFme\n" +
                            "tP8AaCGR4Ld1TNEwIeJdDsa8JHHUijhjiihjQEdkMaRRqxJZ+1FGlViW8Dezsk8n07JeghaFhDLL\n" +
                            "Ow+YN8cyIkZBUAxkhGawQyOJApdTQPVP6j7V3B9j7cEYq8Y9zsx3pLFSCWzB9rO8SPPXMiymCVl2\n" +
                            "8XvJpJe1iVDqAH/Q32gNDlMbflsQ079K1NAzRzQ1rUE0kDqSrLKkTs8TKQQVdQQ29jex6X+teqa/\n" +
                            "SfT2Uzs6xyChXeZIJpWgWdxtkgEwjm9syAMqsUZe7QPB9SzpC90v1val6txcmHoXbqY63jVx1yvJ\n" +
                            "flWs0s1mxYeJYDYSws7Vpk7ZB2KySkOA3oEGld4JdS6yLAp2K6ruQSmiEILbq2Gw3YKbvriaIGLN\n" +
                            "c4scE888Y98XRqzXioV07iA4IDL/AHLsaJB1wQQTvj4Px65j6p6dzK9c9HmHK5zIYfH3jkpYclFD\n" +
                            "kqsjtFdgnjkutAjUhVRoLEIEnuTTmNU7wD22vHdTw5yG1ZigtVRUyN/HMltEjd5aE7V5Zo1SRwYJ\n" +
                            "XRjE/dtl0SAePQzKWldTrRbjtBOu7e+CeO3nR2RrjXg+uhmk0rvSgMUkjYMAwXepS8jDAMSCKI7E\n" +
                            "EA9DY3R4/wAfu+P14WqVLD4BshLiagrSZCUzW0DyGP3VLsOyJ5GSGMNI7iKAJGC7EIN8co0M3jr3\n" +
                            "1Uz1jG4zp/OUWmFDP9G5KTH4/q/AdR0LC/8A6gxmNyNcQ5DH36zi1PYq5BVsR+1PErzCRTfusbGa\n" +
                            "XC3Gwscst4yQoUrCJrsNOSeNLklJZ3jhktxVjI9YSOqmQKSdAD1P8V0HTv1amU61jTPdQslCwti/\n" +
                            "Tx8M+Olou0tQQtShhKWYu9ffsB2kkdOw/gO305o9QkMeplncu08fyAu4tL/YwZlJU7VobXEsboyg\n" +
                            "AspKGhF17EEfv3x+XVjfJERAEBQAdDex8+QCPBOj5/jY1qX9dZJrNODDV2/xsxZWrLpwGWgn+NkJ\n" +
                            "QCG2Pt0MAOuGnQ7B49MVi6ojdCeVB0d6H60dH9a8/wC3PqTteN3PXrrMWrUI/wClVvyJUTlhNekU\n" +
                            "HgFSYYCwB37LAtoaKcFKxkNVGC2c+qwFHGckE12B+nUMBQx3AGPcX+XUg6g+o+I6M6bzNPNLlcZa\n" +
                            "kzGXlAbBZeSs0Ml6YVWit1qc1aSL7NINSLN29nnWiBw/1D9T+lsjLM1bqDGgtIT22JxUfu7uR2Wv\n" +
                            "Yffwfx+dHTc+u1PrPmEjofaAg7HAJ/E/3bY8j4Gvn9cd2zwV1BFjrjTC3Tqzhgw7ZYIpBwSSdMp7\n" +
                            "tH8hsH5Pkn1nyGWwNymsC1IJ75O4370AcWPHW00/w7UM0sul1aSyUXaPWRNHYoERxNowyKKGwNqG\n" +
                            "IAqzQPU66n63pMPscXdr38pe3BTr05o7Tq0g7TZmEbSCGvEP8SR3A/Fe0bc69aFBBRpVaikN9vCk\n" +
                            "Zb8tu4G3c6bW3csx15JPryaONoSzPQo06jSNp2rV4YNn5/KNAfA8cnf6PPrTMmyTsH/QbH/Pd/8A\n" +
                            "X8ePXAHlqJxx2zfJ59sCvxuss0IiSHSLKke8SO7lTJI9BVsJ6USMbti2xJdiWohV/Q9jc5V6v6mN\n" +
                            "CTH3r2HaiZksTVEgGKtxFSvZahm98R5CJ2AVgp74h2jtLbu2NghqQQ14I0hhiRUjiQbVFUaXZ8nf\n" +
                            "k7JJJ2SSSfUq6G6SwHR0E5w9JqsuQirGzHJalt+37KEx10kmZh7cJkdU7QAQAf49Eetevsf0fQqN\n" +
                            "aMwuZaeSji1SrLZiNpa7zs1n2XVkrRxxu8jhg3aO1O59KTShdROkGkVymERSPUxAtnKqzKKANlTV\n" +
                            "KWPJPVrxn/P296/66Zes7vUsgxeN6Yt41J7E5XIJPJXeylU9q+5FXmbciJ/jM5X8lZI9EgsPSFBh\n" +
                            "7fTlOx0hPUsyYyG/BlMb1VYMH29WtYvC/dE84PuQWq1r3kjUKqvDYUBhGmmVPppgurW6ksX8tXwZ\n" +
                            "6fWxbyMdio9s5LH5tnUGgsliR5Z8a8MpsRd7gBZmhaP8Eb1ausqvUmQxsEXS2Qq0cjDcrWJVuQpN\n" +
                            "Xu007vuKcvekgiEwKlZAjdpTkcjWgNujki0gkgdDteSUArUhNq0joWYmK3QKQQEdgQQwPQyC2QD7\n" +
                            "ZxVDIs/lXnPYYuoutwslTHYf3ciMnSvu9/Cxw5abGvEiLTmesDJE8M87NCxclVYAMoUn069K0VxG\n" +
                            "Jr+6D99cCXspI8cUUst6aNDO0iQqkSdmhEkcYCRomh5O450r0vHU6znyWTwuIrZeSgtt7+DsXIlr\n" +
                            "tCyQCjZj/wAKu8c4keyqBOSrM6vsN6tYnDtoA9p5+CAQT+j45IJ2SePS+qMUSpBAbVlV5JMXIxsg\n" +
                            "Agt6UugDt3bQ20ZJpXt5+3HOOOvPUPUtfAYufL2gZIIJKsTqHVAPubUNZZC7EKqxmYM5b4BAO9KJ\n" +
                            "fj4bGR6lyvVslzqIw4mZ6GIrjNQvj7lyZtfbRRUSqXsdIssc/tWy5ry7EYDK3cufUnC9crSyz4Hq\n" +
                            "ahPjrk1e5ZxHUMMcjUYYJ0ksvh7aqdx9iL21LkFiJHXcbB3C+nrofH361XF4vI3UyP8ASI/6lLMk\n" +
                            "SxIbN9S9OuwVI/cNeJnm9wordzjYGgPTESJp9IZ0mikeUtG4G8SLHsjZlKsgCksTGWBIYMSpKjoL\n" +
                            "WWqzyPNZAr/e+eR963iY46FOvCWIfsDTtsHvsSbeaQknZ7nLaPntCr8a9ZLWUpRWoaclmFLU8cs8\n" +
                            "ELMFeWKDt9502dMIwyl+d9pLHYDEaLzLoeB5150dn/XgeP41+t8c3/VfI5jH5/DZ3K9PxZnovC5G\n" +
                            "pDN9tchgtpHl4jRsTz+7NDIyQW3rlYkk9qSP+4e4oJU0kI1k/wAtnCF1dgSVDO4UlEQOyqzO21VU\n" +
                            "st2cgjqSCo5vjGaHk9rHvV2Rm+ujsZlquarfd0yzQCexDDKwAWx9vK0LzREE98Luje2/hwpI1vfr\n" +
                            "ZtWI40eWVhHHEpklkchVRFBZmYse1QqgkltAL50B6UumeqcPlV+wo1rOKs4+CItibtdas0NRx2Qz\n" +
                            "QojSQy1mIKrJFKw32lgpkQsbykcV+naqTjcNqGWCRQ3aWjlVo20RyG7WP8+Pj0GRNkpVlaMbh6Wy\n" +
                            "wQ5B8E1mxgnqtCrvtfnsPHGTWeo/lvqxjJsnlMLisd/WZK0WPECu7wpkWyMphArxz1GWWGFg5kkB\n" +
                            "ZGCt2n8W7ErP9FWuksFUvYbI0caMXKcxkoJK7SILIle3NHh5opIZKn3Uz/ayV2760ySD/BV+wKfb\n" +
                            "prrnp/OR5TD57C52hFj/AOmpj8/Qenbr045lmgWLI4wkTPCAYxLZqszK35eNFc6r6hyObr4bB5TH\n" +
                            "pirmVzIS/RS3FdibG4lvvrMsNiJVBjl9qsFDIrgSmNxsEnYEiQiJNHJH8l9jagfMMjvtQ798UiRk\n" +
                            "bAJWtYyoLVv/AKehUe5P2HHHB5717gHx0y4EzY3A42tPIxsNB9zZLH8/ubbNash9/lv35nB+dDnx\n" +
                            "61bmUYuY+5jskEEDSlf8wI5HHOida40Nj0HyuU7V9sHY4HnXIP7Gz3fO9frjevS9JkWCkO5kJ8Hw\n" +
                            "dc8Ejf8Azr/10MtmZnZjy7M34kE/mTzn36qKJArAAq/rXbzfBuvp0XtZ/GQWlpTZGnFekT3I60lq\n" +
                            "FLcsbEqHWBpPdZO4EBghGwRvg+hljIEAksPB3sgHyfA3x/P+p4/fLf1Zjq5rrTpL+mWWh61wlmvc\n" +
                            "o1mpzSLcxNi5AtyT7pEEYhrRxyrMJ2McYc6QMS/q2WcidaJ49sc7B2fka2ORwPnf88emJ4Uhh0so\n" +
                            "kZn1CuZImQoYir7VKkk745EIYOAPVuT+2+rLknxiqwM1/gWL9vrs5vMLTo2rXcu4oWKId/lKw7Y0\n" +
                            "45JkkZE4O/y16Row9ClXieQvKVaSdyQS1iVjNKzb87dmAPjXbs8+h2dya27dCgGLKsgvWdEcRVf/\n" +
                            "ANlWXwRJYZNjR4jPPHIbMZcJXnlLdhiiY7bgEa41zvZ3oEEa2D8kGLCRKvdyXbnIGFHtdtf1U9uo\n" +
                            "YWTjGBjHjHHv/wA4rrnX6w542cg8Im2kSuO0NwD3N+ye3ehrxvjR0fXKmXvA9/PPOtEb54Pg+NHj\n" +
                            "g+R+/VI67y5t5O7J3FiZG3wWAAOiPHPkAnkHnnkn1DMnZ7WbWzoNobBJ551s/wA7Ov38/CJyxPa/\n" +
                            "IFjGf+xY589FA9OABXe+fbPf9fc9B7Uv4yEOdd2vIOwfjnXA2f3/AM6IXnmkZyyMO061vYPgDkfH\n" +
                            "Px6CPn8yb2egmwbCtjY4JMXYivQSNl1lUtKixMIxWngKdpWZyr9ylW4PrzUzEN2vFa9ueuZVJaCz\n" +
                            "C0c8TKxR45EH4gqykAqSrDTKzKwYlMckYBpTdcMrAblVhlSaNHIvBBU0ysBFkcGuMA1wR+Q8fbr9\n" +
                            "Lef6wGIjlo4+pfyGYNGa1BVoVlsvGgDRwzyK8kaiIzjQG22eACSoK9icVkPqD05h72TujL4q3JXn\n" +
                            "v4bqLGNQyOJyNSQrZelbp/b261mtKsixLKJInjIIbskJM3zufxGV68oVsH1u/TvW2NhtY+PFXqWs\n" +
                            "ZlK57bDVra24oxbgaVovbkpWPdjlJ7QZVUL0T07eyLY6subr0qeU0wuJjnkem8myDNAZVEgWZR3i\n" +
                            "N+90J7WkbW/Rju0enhdU2TS7ZA8issqj1AGIMgBjYBWWWJ7BBDHI6eA7k2CBzj6Hnvz5vx01VIaP\n" +
                            "TOIsRUVWOCus9ljZsMRNMV2WmszMSWZlVS7NpQAOQD6lOP6pfqHLYmtlMoOl+pbQmhrRUrT1rdcx\n" +
                            "K1j2JILhko5unMFDI8QkU9yMVXYAJ5zqDqOrmmoJ05/WenLGNALRmAM9qRpFmjsS2LCxRQiIIO1o\n" +
                            "XEgfgk79CulumOlc/FZv5DpqwjULdvGQU8tcOTgorH2NIcRKXP28Dd/aPYZApV1Q6AZraZ1ijkm1\n" +
                            "FuXVSsiMkjqWDABlLi7JG9WBsCiw4MnOL/eL+vjxnI6tuIx74msYZb1jIW55pLFu9Z7FlsTykFiE\n" +
                            "hURxRroCOKMBEGwNbO/Oev5ijjZbXT9KrkMhEFaKlettShmCMDKhsrHN7T9gco7IU7j+Wh5T7Gco\n" +
                            "dIUKVf7TKzY+ImL3a0M+SapGDsNN+clsxrvgospVQAEPj0p9Y9UXepemLp+m/VuGgz9WOSxJUuCF\n" +
                            "5ZaqRyCWvYp2lFmoWXZWV62wy6K9u/QoIn1E0bGhG8qqZpldYQNwAMvygxRKwQuQOMZ6DIwA5x47\n" +
                            "g+Bf6XQo46E9PdUx9bZNrvWFLJ4uxjrs2RpdN28bFYrJVrK1SGeDO1w0FujbsI7FJPb92Uqpi0rd\n" +
                            "vRGBjkrY9HlHbZuSNbtfGpJR3CMjQ7RDGEiCj8R2nQ5PqMdJY0/Z4KrZlksZK5j8dl89O7KyGOCJ\n" +
                            "GhoxIoWOGsbDMVhVdsqltNv8bOlrlQG48Aca8DWvGgeOD/O9AcM/EJEL7IlCRrgIpuNVU7Rssbtr\n" +
                            "H1WxZ2wzMT0MC8m7B/xmq+32sZz0O6i6uqYgfZBL1i5JAXY0KwtNjoZGMKXras6KkKStsD8nftb8\n" +
                            "Nc+kXA9FZu9buz9d3RmqbKnsUhbkkxN6ZW7osg+KKLDXlWApGY29zcgMmj+PaS6x6PsdRe9cw3UN\n" +
                            "/prLzVBTkuVI4LlaxXR/djjt4+2Ghm7GLBHDJIqu/a29MNXpZvqZRyjUuqJ+lstgY6oWvlcZFex2\n" +
                            "WM6BVVLlCZ7FMhgGJevNGAQBo7OqxukWmJ08sSzED5ocFZgFII+Q5XaM3hJN7AWVBC9Va7zkdqPN\n" +
                            "1jv58Z88Dpq6f6XwvTFmxYxi2kaeJK0aWbtm5HUqpI0v2tJbDyGvW91mkaJGI7ySPJBabeSr1YZJ\n" +
                            "rU0UEESM808zqkUUags0juSqoqL/AHMx0Bs6+PQ0yhtMCdDehvR8DxyRv96H+59Qz6hXeoD1Vg6N\n" +
                            "Mx/0+zVyEJx9u6Icf1GbEJis4yyGjk+2tVlaO1SnKsrsHQK5/D0GJH1k1SS+rYzF5GskRqTQJOSQ\n" +
                            "KHYZZqAYiNxUGrJ45vwOP+cD6dVqfO0cjjXu0ZDJAxdIpu10jnAJBki7gC0ZOwrgaOiRwPXOcuRb\n" +
                            "IdYZW53kw4WrFi4NHafd2v8Avl6RT8SpGYIHGgeOSSCPTn1BnXwXTlaK88cbYzFq1pYDtEFWDbLH\n" +
                            "/wCIIqBQx0GPhefUOwuW9vEJYmZVt5SWfJ2tbO5rrmfWuCAkXtr262O0jyOOG1PnumVFRRkm7sgs\n" +
                            "bAo+lSCaH9YPVOfbj95HP1H09nq3lAe/v1ywOzwNg62P2eAeePnxx6W8hmBFG8o7nEaOxSL+5wAx\n" +
                            "CqD8nWlAPnWyPIUcrlVmimjaSWNZUeNmikKSKHBBaJl0UcA/i40AeRs+o31BjOrhjpa3TPWdsCRo\n" +
                            "ya+aVLUpiEqvPFDlYhHfrvJEGjif/EWNm2ePURIkrBZJViFj+sMEAwCbVWoi7F0M89dtAHbAGR9j\n" +
                            "wOTYF/h1jo5DE9eddUOoauNy1LIYUCzkLEtmNPtCkUkNKn3QTv3x3E9w26LxroBZJELdriw2cj3g\n" +
                            "kMRpdgb0TvjZAPjQ488/vfqVdFy/0/GXq0qdlmDJ3q8kzgmezHHKWhaacqrWSiyGOOZ/7lUf7bOb\n" +
                            "zn21Kw6tqUqI4gNk+5L/AIUZA88O2yB+vk8lnVzfNnSKO/lQqsMQLF6XduNMexLEgYAFWSbJ5cAH\n" +
                            "Pkk/rf7ryetmvkvfuZC8SxMsn20Dk8CGqzA9gG9B5mkfjzv5GvSj1pl0rYizJ7gDMhGieTvjQAJP\n" +
                            "k+d+QfJI9ZY7aVqkVcMNxxBWO+S3G2J4/JmLNvYOz+ufUX+p2eZKiwowI57iCQQPy18nnggcdxB4\n" +
                            "0NkLSNZJ7AAL29KgAducdcATXbu3bxzz9DZ4v2qEdQZFpHkYtvuZyzDgbO/JJ52BsrrfPwPUxylw\n" +
                            "DuOi3bshVPlueNnxsgAk60f9Rsxk8l3tIC/cRsBR5A8ccne+RvfLcngDaDlZpRDO0UwDFX9ppAWR\n" +
                            "XKntZgCO4BiC3K/PI8+lhn98fXq91x7A3R48WOPoT24x1NLf/ZzMy5K5FZfCZ+q8n3Trbaterzwo\n" +
                            "AGlhMgjtV3TQDLG0ckba/Ekqrbj7Exo1DbkjksmvEZpIQyRySFAWdFLbAbyR42TrjXqWdK3Dnclm\n" +
                            "VzeEoy2KOVl78hFLDZiWREhWBUjMYsxmVU9/23LKpOtnhmphncHStH28du/1rjx/HpzVBkYQ5JUK\n" +
                            "1FlfaGVaCsDew3YBogEE8k9DX1DGK7CsWccj3HX3NwHVlD6gWqsXUGOx9C/VzElNM9arT1ZZoKl1\n" +
                            "bMFeBZq6pFPaiEP5C1Gje52qm2G+mst1BJ0/RnvjHXcwIEQipjlje5KCw/8A2VkkjRmVCW7S4DAf\n" +
                            "HrnLqarB0jNew64+1Ph+p8ekFGSKCa01DO04PbgaTsV2iFseyffJH+LEO7SdzKidf9c/Vl0lxfTv\n" +
                            "TtuODpNMRkcllo3eG3ajqx15Z/tnn1SuxzIZRPX0V1E/e+jou/yy6+eD+XMcOn3WFmnCxBCYw9Es\n" +
                            "CpLnYVWzZBUURT7sFB82OM5sV9ft7Yz1170b9R+n/qJi7NnHe9XavanqWcVkIZamTqrA4jdbdSUB\n" +
                            "4+5u780LxsNdrsORQKdhK0KxV0CQAELGgCqCd74H7J2T5be/3vnv6VdR4+9UsLYaSPqHIJHlrcVu\n" +
                            "hHQnkr2ViWOWqIjJFPVH49zxSv2yOe4R9yhrLWn7CVL/AIckDfOzzwd+POh/roE7PrN1kaR6iSNF\n" +
                            "eOMEbY2bdXAsNtXet2FYqLUjvnoe4micHnHbN81nOc9+mxJUlQqSQQ2zvnyAeP15/wDMcjk+oznu\n" +
                            "hkl61vdUPjcdKbGOq1o8+8vtXMNj4EdslXhrpH/3g3e1ZBI7Eodggg8H8j190tgbZo5XLw0r7RGe\n" +
                            "Oq6TvNNEDpniWKKT3ezguE7mUcnQ5HtlcxDnq2IxmPsLLHnuyZ7CEgDFQ6mnbtYB0aZVEPayhgS6\n" +
                            "EbB1fTCfTsHUPHHKrKXYOqslqzFWxuAC8AkMLBsX1UgHHvnP5Hp26UGqL33T22yHY0C8gxUa6iGl\n" +
                            "ENkEgRKHB/zF9k6A2y2MlFRrT2p5OyGvC9iQ6JYRQr3OwG/IVdgc7/8AQIssccMcUZCqiKioi6Cq\n" +
                            "gCqq6+FAGtHwOf16k/1h60udI9IZPI4mxjXzEcHu1cbetVIZbsKOptx1YrTds8v2/uMidkgYggof\n" +
                            "Uwo2r1KootpZFjQG6G5gq2QGoKKs0aFnz1DEKDeME/vnqn9NfUbHdS3rGI+3sYvIxVYsjWrWnjeS\n" +
                            "9iptexkIWiYqFZuHiYl42Kk9ylu13+6AVgwJ/Z3/AHcneyP58eN8cevnt9Iiv1N6zyvUclLN9KS4\n" +
                            "jDVIKHUeLyVigMx/UisyiKp2LXWOpHGYpNQGJ3YgDtAJ7Es2b2A6YtyLdly9/H4+xKlq8sYe08aO\n" +
                            "6NOtdYkJ4G+xU7taJ2e70/8AFNBFpNQsEbD5uyP5sRpvlyOoNLIrMrKQVPqKurEqyAggADlgSbAy\n" +
                            "MnsP8/fjOemnJZapXqSLZvRY9LBNaKxPOkGrEylIhC0rKGmLbEaDbMV/EHZ9QnB3sFnOoO3OdMZF\n" +
                            "s509LNJiOqbNS6cNkhULQ/eU52lMVe4vcyypPDGzkF4mPcEVe+reSq5ro/p+aS9jIL628VnYEtLJ\n" +
                            "YgHsos07GtAr2ZEClo1YdpjO271ZRrPN1fmZMQtq9FjKleWpH9smOnlmFj3F7xZ7pUQxJJGV1Fpm\n" +
                            "3/cTsgCCDT6N5LO+UyRE7zE0WzaAVKi5VkUsjKbWgdwHpbqRkjmsVnm+av8ALjpS+q/UrWpYcNC5\n" +
                            "MuXuw1n7X0yVImFi2/48FFhjCOSRtZRyw5KXZyoh0qkBUUhVGgugO3geABrQXj+APHpAyeaGQ6vv\n" +
                            "2zJ3x4mqK4JbuU3Lf+JMynkbSAJEw8ggqdjj0IvZ9QT+eiATweCd8DXn5/Y8fPrOc0scfei7VdW+\n" +
                            "0896UL9/F4sFJu8Vx5IHt+n2HfDnZzBZj3aAJ5OzokDkca/Xzz8a8D0HfJqGJDaB5/u53vXgDka/\n" +
                            "nwfkekCbOCQFd7IPjjXP8fwdefAJ/wBfQ6TMFQdHQ5bZbnY2ePkfPOzoH51yP9/v9/79coujRrPY\n" +
                            "5+vgdr55+1AsZUIpPfoc87/Z8n98j4I55Px6R8tl/ur9OsHYrCXuTAa57NxQ7HB0XZj/AP6je9H0\n" +
                            "tXc4RvTgeN8n8f4IHG/3vXk6GvSfSzAmmv3i5/xpfYiO+BFWHaCvnYZtsdaG96/fo8XpDPiwKF4F\n" +
                            "tQFHyMn2INDB6ri8Y/6Gbxfv2HVLsZbs7izfiTob4PG+eeTyf4H+nHrnT6jZwT2XiU7C+OdDuPHb\n" +
                            "z4Pnyo0NHXcPTnkMyVjkbu4A358je/IHDcHn+OTv1zh1NljPanbvYgOxB7t75POuPJ54Ug7PPk+q\n" +
                            "MaAU+1nx9PNfvPUjP749z4A5/wCD0Bv2WbucsykEflrngb0Nk8HjjXjQ8c+lLK5KGpTs2bLKkFaG\n" +
                            "SaSQjY7UDEnQBOxrQA5L8De9ncs2/dUqWGwQTvga/wAwPA4O9bI2B4OtD1FesevLOLupgmxy1fvr\n" +
                            "KVoLuQYNjbsMkTl4vdTXsyuV9tS/cdhvHI9F0+mfUSBEAJB3MLUegUWIvmgTQAJ9qHVWwLuuwNX+\n" +
                            "+OP+OmTpOKwlCbK3JEks5yX79wK6QCOIxhK0ZVQGLCEIZHc7LHXga9GBMpGyyje/8xHz+tj/ANAf\n" +
                            "3z6F4WZ/6NQSaSKSZIVV2hb3YwVJDIjkbbsA7AeDxyAfGy/5Ozdp5PxwP+NH/wBT6rMbmkJAPqoB\n" +
                            "QKABAAA8UAo/56rk+DdEHjjbf0yLr8eKP6b7h74w7dujot3ANrZ45IOuToEaIP8Ap60J0r2IZIJo\n" +
                            "gyTxGGRNhgUlUqwY/IKkg8kn9649acl1iyxt/aePOg2zyT/I51x452fBzI8Z3yO/xosvHHxvWv34\n" +
                            "8/PpcDbwSDjIJHcZ7+P+R08x3VQPj7/p+zfSj0j0PL09mfvHzFi9jaEdmHCUZokD4+C4ytPWa2hM\n" +
                            "lmBGUewku/ZACggAj1VpbcFKKSxNOkdeNDJJJLIqRxog/J2diFVQFJ2SNAbP69B4mRAQSShHkcaJ\n" +
                            "+T53/IGuN6I59InWfV/SuLSp0/1Pe+yj6nFrG1Z5UeOn3GtIzpPdZfYqu8Zb2TOwDsoA2dbJ8yXV\n" +
                            "TKGDO9AelQz7RliAtbjW5ycliSTyT1Kp6cCzQoccfc9v2OwjqHM5rrDJSxdG1unxdxEa5HC5/Jyr\n" +
                            "bq5CQbSWvWal3FYWLNBZ7mbtLFin4kGldE258jNazF2KKvNFDHi4IK7d1WE1lVrv27aUtE9wnsYh\n" +
                            "SQNHfI9c39GUH6diztijn6mZgqyS1MM1CsIa5lyYSCCJpleSGzNBDGnuPCQjMN+e4+uj8LDHh8LU\n" +
                            "qe4iLXgBnlJAUyNuSeRmYAaeVpG7vIB8+fWnrGjjiEMJDINqxsVdZDuCvJe/Is7bWgFZnC1ZHQio\n" +
                            "BsjP6H2Hvz/30z9S9ddO9H1ILmfyaUIrEnsxMYp52eQL3MFjrxTSkKp2zdnag/uIHr5//VX6mdBd\n" +
                            "ZzZqeepj+qLGM6kSrPFJl4aWSTFSiOKpJiMfMI7NtUjZpO2EoZWVkLJIPXYOfWj1FWjWncpNkqDm\n" +
                            "ajZVorSVZWUxuXjVyrhkJVlbg/I1oek2h9Jvp0DXtZXpbA5XNQqDLmLOMrm5LN7jT96yFCVCSOzI\n" +
                            "oO10Ncn038H1mg+HH5+pj1Tai6UROEK0wPG1WClQBYk3biCFIFETncQBRGeLs+3vnxz75HTR9Ksb\n" +
                            "UwuDWelVlo4+7BVGKo2fc96njK8RWtHIsnc6yOZHkZGLEDt2x7j6q0+XT2Wik5RwyFPIKldEH50Q\n" +
                            "deCD/BOgnTXIolVItIsahFC/CKO1VVda0BoceNfAJ9KOQ6hWJzG7hSPgk+dfB1wNeP4OjvQHrI1G\n" +
                            "oaaV5TuLO26yxJrBFsbJNUCTkmyfeKwPfxnx+pN1znJPWt1VWxeFxV1MLi41t5PdQSICxiW73JPJ\n" +
                            "3ys/swxxPIT2doLFV12naybrPqmvisbFVE4FbHUkVm3oBK1dVY+TwEjLHk+SNEkD029QdSRrRlYM\n" +
                            "rKFfZZgSdb1on5Pzx8a3++Gfqh1fLYi/p8c/Y+VvR1AAT3eyX752BHgBFZWG9acg736o8zzfKjYl\n" +
                            "hv3MzMSx/purJNKq4r365AFs9hRF3gkgDvZ/eOmTGZx/sGuTOfuMpYnyMuzv/wDqHYoq78KsQjAB\n" +
                            "8Df9uifQmz1AsjOO/faSNsdc7PHjZILDXGidEfHqcW86EjWOOTSxIscY3wERexQAPgAAAaGgAPOj\n" +
                            "6WrObILgSEEqRruBGz8kEHR/QPJ53s8+ly5kd34BY0PAxQHegKFdEAwMgHm6GBQ+33wTR5z01dT9\n" +
                            "b5LErAmKpVclasGVYa9jIw0GlkRO5EhDo5mdiQCEI1+x59AOmczn1Ni9nMm9g3YI2loNJG8WNviR\n" +
                            "/erVhEAvtxrqMsG5ZASN8nn36qzZO9JhblbMU8PBiLAuLYk0MhYuAlUq0wSB/ioT3f5u5dhWG/Tv\n" +
                            "i78dHE0oI3kKmFJXedu6eSWdRJI8zNol2ZiW4GjtRrQHp+QRx6OJk+W0k25ZPSxdNrWBuJ2jG1vQ\n" +
                            "Af8A3OACOyGIvsCtcHIOKPvYwO/2q+W6jaGrYlDbYoVj0QfzcdicfP5MCdb2Brjn1oV8l9vWhg7w\n" +
                            "DGiFiCR+bbLf8sTon9D/ADD1Jb+Z92xRqBwVMv3Up/y9kIJUNvS9pf8AFhzyBxsDe5NmtjYcAkbH\n" +
                            "IAP7B1vegPOiTvnWuQihGi4Ja2P0FAe1jPNGs9cMWeRQ9qPsaNG/PYY6c81mylaTtccow7QeRvYJ\n" +
                            "3z4/kHkAHfHqF5G87yH8gQSx5+OOP3rXHjetb50R6KZvMn2jH3bJXzvjwRyfI4AHkefJ9Tqe8xZj\n" +
                            "42TwSCdDuG9652TzscHXHwQNdi/FcAVXtfvz9eOu7d7JPc449/qK4PXrmL9urWM9etHakBG4mlEC\n" +
                            "9vO2MjKyqFA3yNDZ18+on1h1bWytmr03kunZ0u24RNj5JlFusLrP7IaGSEgGIRs0gnfsA1sgaHqt\n" +
                            "3HjtVZ68/wCUdiN4pAW0DHIpRvyGircnRPPJ2SefUqxePlxnU1GATHKUoqFmOlLJ2s+PrGQOgWcE\n" +
                            "iXb/AOErEE9qnRCqF9aegMSq8jJckSs6EFlJYDFMDt9JH9JGQSAbBujCsX/VVX5xQIo1gX4z9D1T\n" +
                            "KEMGPo1adaNYkrwRoqKvbyEAZu0bH5OSxO/7tk78n1fJ043ZHt1kdTpkexFGyn9MhfYPzz58/PrE\n" +
                            "8mlPO+3ZOtEn4HO+d/2jj+NHY9RXK5LoCzkrk1+9FVumd0swTPIkkcsX+CwZRsDZj7hrggg/PpSO\n" +
                            "JtQ7kiRu5KRlzuZgMgWR3z+OcGp7AGjV5xg+/tQ5z9e36vmmVtAnnyOed8/ofHJ/Y+dA+h2Uz9TC\n" +
                            "4+zkr8jpVpI8srxxvI4QeSEQdzED/wCtDQDtcbZfv47QQP8Agka5/wBv4+f1q2LEduCWvMqvFIjR\n" +
                            "yIeAVcEMN88aI14+OfB9DVVJQtZXG4A+ojGAaIGLokGu+OnOjGP+onTuShBr5KKOURK8cF7upSSd\n" +
                            "yjs7VsrGHB/HXtF1/Z35VMp1lhuoMemKs41realtLXONnovYWN/dKfdpO0ZqmAQ/msschfTBWXXc\n" +
                            "BHequpKfSDjB53DPawmRlr08Nn2rxzw0rNqXsWleK/40MShtQzjccf8AZJ2oV7aj0/0niOnLUWQx\n" +
                            "T2UL1RFPCLDy1Jy2mEoiYsiNsbV140QBrknQfT6bToJ6mp/Vp3DIQ5TbYMi0RtLU6lQ4IGQMnhIS\n" +
                            "MDBNcDwOeb++K966dnxca2sOlaGvWxePdrLVYUESvaChYSUjAU9h/M9w3sAc75H9TMc9nOn8Dasy\n" +
                            "V8W628hcrxStF/Umqge1VkZNFoQW9ySMnTqOQNA+tuS+GGgdKedn9+OQf/fz8/oRf6udWnpyDBZC\n" +
                            "COz98mQIo3q7xKKkxrsxSdZWVZa1ldwyxk7cbIGt+haD5s2qiRcuwdIzj0uysQ+cbgaNjIoFcgdV\n" +
                            "YjaScjBwfcHkdf2b6z6Gx/WU3SYw2T6YarAz0OsaySVcbPegcNLQhmhY+7NF2gmOVQXB1GnkipdF\n" +
                            "daWOoMO9qd/cevft0VtBDEtyOs6qtr2WVTE0qsNoQB3LvQLdq8uHrWW/coXzRSazmJpp8VjprdJ8\n" +
                            "YuVkREuWow0ZtxmPas1WR+1CFVJOTIbF080mExUVSWVJbTtJatzIFRZLM8heUqq6AVSRGuhwqg6H\n" +
                            "xp/EkSGCOJlczbUppJvm2ylhKyEruRWICsu4oHB2jFASk3eCLzQAABrHj3vH4dVy3nNKfzGzyRvj\n" +
                            "nz/O9+N/vZ0N+pvn+oEYSIx0QCVYnQI55BI4Hjn/AMwdaQur+sLONxGUuU4hbuVKdiatWZyonmjQ\n" +
                            "ukZIAbT+Px5IAAI8jmOt9QbnXyYK8+b+yp24ZlyeGx7oSbNUBmSWcj7uuqSo0UsRKq2iSWXt9Y8e\n" +
                            "lkmjkmtUjiIEjMSSCULABRZIYKwU4W8EgZBaFAffH2yO3Of0HVu6w6xapipEWXUv5KCWOtHgsPB4\n" +
                            "Ut58kgHfzxL1F1QMj1SFd9pi6ryMfj7mySqhQNdpMYUk63s8jZB9On1J6xRT9vE4CQLrfdsfivI3\n" +
                            "o9w+SSCd65PHrj6PqhrN+7bMhD2rM0nLEn2oz7ceyd+ApHHB8jY0fS8QxK//AKqQv/8AQAv2tdx7\n" +
                            "e/A6qwAIrNnOL8EgD64/K+erfc6l/JiHA40D3b/n9Hne9b58nQPoJL1GWViJNbXzvWjwAdf27142\n" +
                            "Qd74PgSOx1AWOwzEbG98jyRs8Dk7BG9jfkefWi+dY7G/H8658nwCSfjyBoa1s+qoMjHGAearzx4y\n" +
                            "MffvxHc1RAznnGeMX9KrGCejHUZz1sqK+Rp3US3FZrLfrL71FlmDbrzR6YlQWC+53gDtHjj02P1C\n" +
                            "xjQMw7iFVtEaLAc8gHWzvWxrnz51KnyzP4Y/JHJ3ryPkb5Lfrxz8+tR8oyJJKXH+GjvyOD2DY14H\n" +
                            "GyRsgE/rwWZHaVY0IWkutqqv9VA3WM0Dxk3Zs31VVAs3WADnNdzffkCjf4ijRoM37t63M7AJEq1k\n" +
                            "IJOiPzkBOyeGOief0db9bEubLd35/IHGv9+f343+/O+OZbj7x+3Vn13TM0r/ABsyEtv451o8eNa8\n" +
                            "+s732VtliU5Cga4JH+3yPkc742N+qMvrPNLQU/8A1r6E3n/ntAGQDm/xAxR4+9+Bnm+nG7kmkJLO\n" +
                            "SADrnwdnYG+3kcb/AEdjfoNJZBIPd88jg8nZOh/H+x35P6Bf1At3ckjXBJ/Z89x8nZ15A3++R6wy\n" +
                            "WG1tRzscAg/r/TnydfzvRHipS/39ORgeeK7c9WA7rnPccURzXfj7X9OhvVVXMW1it4TIPXnrK4em\n" +
                            "7D7e5G6g9sqtsBgNgMQ3HlTztW+nk2SNa6+X91LsUn28UcjIVSqHkkQRdmtozMx2w7h+I3261561\n" +
                            "vyLSjgimIkmMgMcUwimKiIgSLtg3bGwJ7ed6+e3Xrb6VryVMbDPYsS2rNuGFp5JiNr2oBGNgf5QR\n" +
                            "yfyb8mZi3J0g3y/h5U7P9RwsZ21JQILAtQtTkZvNAGuhG9/2xZsHAGPBA+/bAPTblntyY+5DRlEN\n" +
                            "yWCRIJwFYRSlT2PzvkEkc/PJOtb55/o1FC65KjbnviST7qeWrNYklm9xi0jTIhWTv2GDA/2kDyPV\n" +
                            "zvXfta8k4ilsdgUGKJSzt3ELtQTo6Dbbf+VSd6AI8LIHUOIx+QB/IKSN/B58jx/8+fS2m1cmmD7V\n" +
                            "sOwJYHYSVrF1xnI4JF+T1RiC3Y4A5r9KBP8AnPB6/RWuWDxoQx4BDDgc6G9EA/6gjf71v1sJfABY\n" +
                            "6II12k8AH/N45P8Ap5/a6HqeLe7GITQGl/jk71v+eONa8bJ/e3BkO4j8t88gbA0P9f3xvW9D516W\n" +
                            "vtijwPasDnF+/ORjFtqSRfB+nOBntz04TrTufjcgisRBlcJNGsiB0O0dQwK9ytogjRB55Pot94qR\n" +
                            "qEICqFVQN70NADXxrzrkfIPPpIS+Se3Z1vfGgBrZA3/5A7Oz4J0D68PlABy2v9+SP9edeTx5I3/P\n" +
                            "qDuoXZUZFHzWa4GOTV4zij1Q0DijfIIrOOeOaH6V0zzZIbIJ0Rzrf618c8b0QNE8kkb5MT+sfT9r\n" +
                            "r7p6HC0ZakEseSr23nt97LEIS/5oiEFpF7j26KjZ3z49M17M6BPcFXelO9eP3/J1wPJO/wDLyEy3\n" +
                            "nAWZhINKW8k62fPkkb/Y3wN/jrfounmfSzR6iMhZYiHQsNwDA4JWuOBnBz2q70CtHg9uLFjPar9v\n" +
                            "P06Wul+g8X03ar5DI2P6xnK8EcUVuQe1FV0io/2tfZWIuQWd+ZGJ2zsSdvN/qOGoIvdnjiMzmKJH\n" +
                            "cKXlILBF3yWOvA8j4+BOrGe75PcEo4JG/O9EDkg6+TyDwDr9j1EvqP1fNXzmDkjgsWcfjIrVq89X\n" +
                            "UjV55UMdWQxc+4sbKztxsKTobBDFebUfENRc8rSPsY7sAAAFgqrhACxoIKFniz1QgKoAAoVx9sms\n" +
                            "5Jz4wfHVH+ofVmRqVy+EioXMhK3Fa5ZaukkY/FgpVHDNoaAK65IJCkkQXp6axhRnsnkMfjcbLftN\n" +
                            "ahhoyFzGZE3YDORod8n5kqPILc/MPyPU3Tuea/UyU2RfqGF55KOTVrqzyF5S8LxhQWrnwhDKIyuy\n" +
                            "JO4lVwZrPSYnDCBr9uzNPCne12zJM6EqGKguxIAYnQ4Pg8hQVYnX+U0rQhqaUqHuJlLgbWUq3zCr\n" +
                            "ID5RWst7jqqklgQL4IOMUBjjHcDxjPbrR+oPWJlTJTiUlRHMdgliD2kAdi75GvOt+dKefUKxV2R4\n" +
                            "Tb2QJUVYAw1/hDbdxU7ILMSSSd8HfnZ2cjmGnd+49yknyeCSfnfkfvzsDxz6Ay3eFVSqD/w8AA7+\n" +
                            "OOf41v8Afk8ZattiZAMsQSb4oAfTJ/6z1ZiSQb47AEEcZs1yeME9z0z/AH3PPzryf7Rrk8jWzydf\n" +
                            "J/10cT3SdHu8/wDG+eAPjz2+dlh5GiQpPkRGrSOwUKCWYHggb3oAEk72Rrk60N/K/Y6qqvFEMcyX\n" +
                            "LU7lYIgxUDTEEy93a0YVh/mHcTsaIJINHG7YUE+TWAas2eAK/Q/QVvIBOPHsK8ZzVkdj+VIFzZJL\n" +
                            "a3sD9b0NAjnYIPxrR140Nad6wTF7YbZnZY9Hfgnbc886BHOt73rgekbF5y9Pcko5DHS1JUHuJZRh\n" +
                            "JVlUkDQkJUq2jvt53s/lvQ9G5LHu3YU3pYUaY6P+Y8A/yRyQCQOD459FClHyAaG7FEEdqIvN0Prj\n" +
                            "ru33P4496GCPfpujsAAKD+KhVAG9g6HgAD+TrXjwQBz7NaVh5O/jnZHj+0+T+wPk73vXIMTgAkEe\n" +
                            "DvkKf/43wfHB2PjWJrBB0PG/JOtj5/53vnxs8Hz6HV8HHaz9PzOPb8OoJP6D9BX+Pz6OrPsjRPnf\n" +
                            "Hjf7/kcDjX6AJ8HIbJVSzEAAEnkgADZJJJ1wAefIB/XkAtjY4/8APWtbHJ4GiAAOfknWz695JwyN\n" +
                            "GdAMrAjnyQQQR8/r+eNeAR1ZAo/7+/b79cCaqz9bwbHYXj/npO6sOEzFvGSR5AvkK06CCKrIzh45\n" +
                            "JVWUTditGECrpu7QIBHyCaJFKI0RAVAVUVVXQAUjxyDoDwDrkjR8epMMVkcblq0lKCGWv9wSJ2ZR\n" +
                            "JHVY9zxTKd+6ASezkMp53oaD1ayApwSWCpkEaksoIVteSeeDrgfHJH8H0zPTJp40cyKAdt1YJIxX\n" +
                            "9ubGTfPHXKoJJOMc84x2F9/p5+v9n+opcN9q60pLcE06wzNGwZog5OmEX9zknQAB8ttjoEEnWyST\n" +
                            "wRTBHjEi9wSVSJFBJ4YLsA/Otn+efUj/AKg2Yz0JSZ3jgnDNRtRSBo0ZQe+NhtV8jsOzxzr/ADeq\n" +
                            "QLWhoEADYAIA8H+SD/5D0KeOONYlIAkI3ObIGSKFcXXJx9uel3JDf1bfb7g9qrnP49r6+8dbLqwA\n" +
                            "L/2gEluON8nXPnwN6/Q436JR5NEPdvYbRGiNAflz/A//AI9Tamzd+tnRRNjZ1yFB4/kcejbkiJNE\n" +
                            "jWtcnj8l9AIFjnNDnxZvjnFewPTYY0B7Nn/60R+vtXbp3XMKNMdAc7A8cAj543sHWz8kD9+hd7Op\n" +
                            "2gK67/1B2ef9/wBaG+fHOtelGRm9vfc2zrZ2ed8nfPOzz/r6Wrckm5PzfhePybj8h4548n1cqAFI\n" +
                            "vuKvFA4/76rvB22LJF3fuMVXGa8e2ejeT6g0HHuHg/28Hz4GgfknRJ0fga5IRr/USKrBZNAn5O+P\n" +
                            "9d/OvB/3+R6G5R375Pzbz/4j/wCEH9/vn0h3WYsdsT/f5JPwvqteTf7/ANvPRAxI8Zr7Wo9vPava\n" +
                            "umK1n1RGPdvQ8nQOyPnfzojgg+fg+IkOpr3v5i1f1G1i3IK6sdla0QCQ+TobXyN8EbB0dejWUdxC\n" +
                            "xDsD3NyGIPg/O/Uo6hdwH0zDgHhj52OfPn1BJVXr+8KCc2KYHBvgmrHtjoZagprurVeLavbt26VO\n" +
                            "qMwkvUWNtVo0Rq8dk2rARFVkkACRlgB3N3AseOPw2eAVlXV3UjWrLr377SRocsAN62PjyPH63x8n\n" +
                            "cy77k/Jvn/Mf/F/r6jOYZjM5LEnUnJJ3wTr/AI+P1653LbEPCKEBJu7Ib689r+h6uFC8dwhHturF\n" +
                            "jxWKrk4z17TZByTt+QdkcaO/AHI/eydnR+OOcf3pbeyN/A8EAf7Hejxr/YcegRJ/xOTwrkc+D+x/\n" +
                            "PrGGYM2iRrWuTxx8eoUWAc/9V9uRfF+b6qxzQ7EjJJsXx2rj910Su3LRgb7Iw+8CNCYMyMNgsp5U\n" +
                            "7bj58c/5h6n+Jmju9SGexilqPF7sAsxv/gzTxHuLxxkDtI0dnbbJO972W9mbcnJ8n5P69JmFZjmn\n" +
                            "UsSolmIUklQSOSB4BPzxz6b0zkRTYzsNEEhheDm88dx0MiyPufwI+nn3Ht1Wks6AOwDo75GzrYI/\n" +
                            "Y45BOvPIOgfXpUs+7JYl/ThFPGtJrnW+ASf1/wAeQLUnvA2db8bOv8v/AMn/AJPrxSJFY6JH+K3j\n" +
                            "/wDxB/8AUn0Bf6WPel49yD+o/Zz1BOQKwTR/Af5yO/36afuOQCQT4Pkc8aGj+RG+d+OdfGx6Gb+d\n" +
                            "EfxoHYO9a3o+Ds/zyO06GpyOeduwO+djR4P79exJ7xz8f+x/+B/x6KBQIBqjzXsD/vX06gGzfgjH\n" +
                            "kmhZ+ldgOiSz+QGAJB3rkkEHfjnYOyf9z4PrRyeXTHVhOY5JtOsYjhUmQs57QfA0Byzccgb3ocei\n" +
                            "E9y8n+0f+voVfZjLApY9pkJK7OiRvRI8HXxvx65FVnAYWMggGr217YvHHFd+rfXNEDxztPnz+/LJ\n" +
                            "HaEiJKOO5Q/a3DAkbAPzwTrY1x8884ppFnjlikUMjoUYA8EMNH+d71ojwfIGuRmzo8nhmA58AKdA\n" +
                            "f6fH69eWZh4Yjg/J/wDEP/k/8n9+htggjGAR7f8AVY/O+igkqeMGuBZNDJwb5H4e/QA0Bi8hDYrS\n" +
                            "2JGmZYnRgXRYVGgoJJK+3oduhoEAc69M4tHQ4Txv4Pnn9f8Axr9Dx60W57N8+f8A/r1lUDtHA+fg\n" +
                            "fs+olkLhS2SPTd0SORdeO3Skl3g9x281+n59+v/Z\n";
                    productname[i - 1] = "errror";
                    productdesc[i - 1] = "errror";
                    price[i - 1] = "errror";
                    rentername[i - 1] = "errror";
                    number[i - 1] = "wrong no";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        recyclerView =findViewById(R.id.recyclerView);
        layoutManager=new GridLayoutManager(this,2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new RecyclerAdapter(images,productname,this,productdesc,price,rentername,number);
        recyclerView.setAdapter(adapter);
    }
}
