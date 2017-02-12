/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vision;

import UtilsVision.SimpleKMedias;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author Adiel
 */
public class Utils {

    public static int min(int a, int b) {
        return a < b ? a : b;
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static BufferedImage IncreaseContrast(BufferedImage imagen) {

        contrastFunction f = new contrastFunction() {

            @Override
            public double getvalue(float x) {
                float e = 1.3f;
                return (x < 0.5) ? (float) Math.pow(x, e) : (float) Math.pow(x, 1f / e);
            }
        };

        BufferedImage imageActual = imagen;
        System.out.println(imagen.getType());
        BufferedImage res = new BufferedImage(imageActual.getWidth(), imageActual.getHeight(), imagen.getType());

        for (int i = 0; i < imageActual.getWidth(); i++) {
            for (int j = 0; j < imageActual.getHeight(); j++) {
                Color p = new Color(imageActual.getRGB(i, j));
                p = new Color((int) (f.getvalue((float) p.getRed() / 255) * 255), (int) (f.getvalue((float) p.getGreen() / 255) * 255),
                        (int) (f.getvalue((float) p.getBlue() / 255) * 255));
                res.setRGB(i, j, p.getRGB());
            }
        }
        return res;

    }

//    public static  void mostarresultado(final BufferedImage img) {
//        canvas3.setImgprovider(new canvas.IImageProvider() {
//
//            @Override
//            public BufferedImage getImage() {
//                System.out.println("pase");
//                return img;
//            }
//        });
//        canvas3.repaint();
//    }
    public static BufferedImage DecreaseContrast(BufferedImage imagen) {
        contrastFunction f = new contrastFunction() {

            @Override
            public double getvalue(float x) {
                float e = 1.3f;
                return (x > 0.5) ? (float) Math.pow(x, e) : (float) Math.pow(x, 1f / e);
            }
        };

        BufferedImage imageActual = imagen;
        System.out.println(imagen.getType());
        BufferedImage res = new BufferedImage(imageActual.getWidth(), imageActual.getHeight(), imagen.getType());

//        Bitmap use = (Bitmap)bmp.Clone();
        for (int i = 0; i < imageActual.getWidth(); i++) {
            for (int j = 0; j < imageActual.getHeight(); j++) {
                Color p = new Color(imageActual.getRGB(i, j));
                p = new Color((int) (f.getvalue((float) p.getRed() / 255) * 255), (int) (f.getvalue((float) p.getGreen() / 255) * 255), (int) (f.getvalue((float) p.getBlue() / 255) * 255));
                res.setRGB(i, j, p.getRGB());
            }
        }

        return res;
    }

    public static BufferedImage IncreaseBright(BufferedImage imagen, double m) {

        BufferedImage imageActual = imagen;
        System.out.println(imagen.getType());
        BufferedImage res = new BufferedImage(imageActual.getWidth(), imageActual.getHeight(), imagen.getType());
//        double m = 1.5f;

        for (int i = 0; i < imageActual.getWidth(); i++) {
            for (int j = 0; j < imageActual.getHeight(); j++) {
                Color c = new Color(imageActual.getRGB(i, j));
                c = new Color(Math.min(255, (int) (m * c.getRed())), Math.min(255, (int) (m * c.getGreen())),
                        Math.min(255, (int) (m * c.getBlue())));
                res.setRGB(i, j, c.getRGB());
            }
        }

        return res;
    }

    public static BufferedImage to_gray_scale(BufferedImage imagen) {

        BufferedImage imageActual = imagen;
        System.out.println(imagen.getType());
        BufferedImage res = new BufferedImage(imageActual.getWidth(), imageActual.getHeight(), imagen.getType());

        for (int i = 0; i < imageActual.getWidth(); i++) {
            for (int j = 0; j < imageActual.getHeight(); j++) {

                Color c = new Color(imageActual.getRGB(i, j));
                int gris = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
                c = new Color(gris, gris, gris);// Color.FromArgb(gris, gris, gris);
                res.setRGB(i, j, c.getRGB());
            }
        }

        return res;

    }

    public static BufferedImage threshold(BufferedImage imagen_procesada, double d) {
        BufferedImage imageActual = imagen_procesada;
//        System.out.println(imagen.getType());
        BufferedImage res = new BufferedImage(imageActual.getWidth(), imageActual.getHeight(), imageActual.getType());

        for (int i = 0; i < imageActual.getWidth(); i++) {
            for (int j = 0; j < imageActual.getHeight(); j++) {

                Color c = new Color(imageActual.getRGB(i, j));
                int gris = (c.getRed() > d * 255) ? 255 : 0;
                c = new Color(gris, gris, gris);// Color.FromArgb(gris, gris, gris);
                res.setRGB(i, j, c.getRGB());
            }
        }

        return res;
    }

    public static BufferedImage laplace_filter(BufferedImage imagen_procesada) {

        float[][] data = get_data(imagen_procesada);
        float[][] datax = convolute(data, new float[][]{{0, 1, 0}, {1, -4, 1}, {0, 1, 0}});
        return Utils.bitmap_from_data(contract(datax));
//        return Utils.bitmap_from_data(Clamp(datax, 0, 1));

    }

    public static BufferedImage sobel_filter(BufferedImage imagen_procesada) {

        float[][] data = get_data(imagen_procesada);

        float[][] datax = Clamp(differentiate(data, new int[][]{{1, 2, 1}, {0, 0, 0}, {-1, -2, -1}}), 0, 1);
        float[][] datay = Clamp(differentiate(data, new int[][]{{2, 1, 0}, {1, 0, -1}, {0, -2, -2}}), 0, 1);

        float[][] datahipotenusa = hipotenusa(datax, datay);

//        bitmap_from_data(Clamp(datahipotenusa,0,1));
        //umbralizar(bitmap_from_data(contract(datahipotenusa)), 0.8);
        //BufferedImage nuevo = threshold(bitmap_from_data(contract(datahipotenusa)), 0.2);
        //nuevo = Util.bitmap_from_data(Util.contract(datax));
        BufferedImage nuevo = bitmap_from_data(Clamp(datahipotenusa, 0, 1));
        return nuevo;

    }

    public static int[] get_histogram(BufferedImage img) {
        int[] res = new int[256];
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                res[(new Color(img.getRGB(i, j))).getRed()]++;
            }
        }

        return res;
    }

    public static int[][] histogram3(BufferedImage img) {

        int[][] res = new int[3][256];
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                res[0][(new Color(img.getRGB(i, j))).getRed()]++;
                res[1][(new Color(img.getRGB(i, j))).getGreen()]++;
                res[2][(new Color(img.getRGB(i, j))).getBlue()]++;
            }
        }
        return res;

    }

    public static BufferedImage[] histogram3IMG(BufferedImage img) {

        BufferedImage imageActual = img;
        System.out.println(img.getType());
        BufferedImage[] resultado = new BufferedImage[3];
        int[][] datas = histogram3(img);
        Color[] colors = new Color[]{Color.RED, Color.GREEN, Color.BLUE};

        for (int chanelindex = 0; chanelindex < 3; chanelindex++) {

            BufferedImage res = new BufferedImage(imageActual.getWidth(), imageActual.getHeight(), img.getType());

            int width = imageActual.getWidth();
            int heigth = imageActual.getHeight();
            int[] data = datas[chanelindex];

            float w = (float) (width - 2) / data.length;

            int max = -1;
            int pos = -1;
            for (int i = 0; i < data.length; i++) {
                pos = max < data[i] ? i : pos;
                max = max < data[i] ? data[i] : max;

            }

            float h = (float) heigth / max;

            Graphics g = res.getGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, width, heigth);
            g.setColor(colors[chanelindex]);
            for (int i = 0; i < data.length; i++) {
                //g.DrawRectangle(new Pen(barColor), 1 + (int) (w * i), heigth - (int) (data[i] * h), (int) w, (int) (data[i] * h));

                g.fillRect(1 + (int) (w * i), heigth - (int) (data[i] * h), (int) w, (int) (data[i] * h));
            }

            resultado[chanelindex] = res;
        }

        return resultado;

    }

    public static BufferedImage decrease_bright(BufferedImage imagen) {
        BufferedImage imageActual = imagen;
        System.out.println(imagen.getType());
        BufferedImage res = new BufferedImage(imageActual.getWidth(), imageActual.getHeight(), imagen.getType());
        double m = 0.7f;

        for (int i = 0; i < imageActual.getWidth(); i++) {
            for (int j = 0; j < imageActual.getHeight(); j++) {
                Color c = new Color(imageActual.getRGB(i, j));
                c = new Color(Math.min(255, (int) (m * c.getRed())), Math.min(255, (int) (m * c.getGreen())), Math.min(255, (int) (m * c.getBlue())));
                res.setRGB(i, j, c.getRGB());
            }
        }

        return res;
    }

    public static BufferedImage Blur(BufferedImage imagen) {

        BufferedImage imageActual = imagen;
        System.out.println(imagen.getType());
        BufferedImage res = new BufferedImage(imageActual.getWidth(), imageActual.getHeight(), imagen.getType());

        //img = Bitmap.FromFile("piratas.jpg");
        Graphics gr = res.getGraphics();

//            bmp = (Bitmap)img;
//            Bitmap bmpnew = (Bitmap)bmp.Clone();
        int ventana = 5;
        int div = (1 + 2 * ventana) * (1 + 2 * ventana);

        for (int i = 0; i < imageActual.getWidth(); i++) {
            for (int j = 0; j < imageActual.getHeight(); j++) {

                Color c = new Color(imageActual.getRGB(i, j));
                int sumaR = 0, sumaG = 0, sumaB = 0;
                for (int k = Math.max(0, i - ventana); k < Math.min(imageActual.getWidth(), i + ventana); k++) {
                    for (int l = Math.max(0, j - ventana); l < Math.min(imageActual.getHeight(), j + ventana); l++) {
                        Color ctemp = new Color(imageActual.getRGB(k, l));//bmp.GetPixel(k, l);
                        sumaR += ctemp.getRed();
                        sumaG += ctemp.getGreen();
                        sumaB += ctemp.getBlue();

                    }
                }

                res.setRGB(i, j, (new Color(sumaR / div, sumaG / div, sumaB / div)).getRGB());//.SetPixel(i, j, Color.FromArgb(sumaR/div,sumaG/div,sumaB/div));

            }
        }

        return res;

    }

    public static BufferedImage Convolute(BufferedImage imagen, double[][] filter) {

        BufferedImage imageActual = imagen;
        System.out.println(imagen.getType());
        BufferedImage res = new BufferedImage(imageActual.getWidth(), imageActual.getHeight(), imagen.getType());

        int ventana = filter.length / 2;
        int div = filter.length * filter.length;

        for (int i = ventana; i < imageActual.getWidth() - ventana; i++) {
            for (int j = ventana; j < imageActual.getHeight() - ventana; j++) {

                Color c = new Color(imageActual.getRGB(i, j));
                int sumaR = 0, sumaG = 0, sumaB = 0;
                for (int k = -ventana; k <= ventana; k++) {
                    for (int m = -ventana; m <= ventana; m++) {
                        Color ctemp = new Color(imageActual.getRGB(i + k, j + m));//bmp.GetPixel(k, l);
                        sumaR += ctemp.getRed();
                        sumaG += ctemp.getGreen();
                        sumaB += ctemp.getBlue();
                    }
                }
//                System.out.println(null);
                res.setRGB(i, j, (new Color(sumaR / div, sumaG / div, sumaB / div)).getRGB());//.SetPixel(i, j, Color.FromArgb(sumaR/div,sumaG/div,sumaB/div));
            }
        }

        return res;

    }

    private static float[][] Clamp(float[][] datax, int min, int max) {

        float[][] res = datax.clone();
        for (int j = 0; j < res.length; j++) {
            for (int k = 0; k < res[j].length; k++) {
                if (res[j][k] < min) {
                    res[j][k] = min;
                }
                if (res[j][k] > max) {
                    res[j][k] = max;
                }
            }
        }
        return res;
    }

    static Point center_of_mass(BufferedImage escaladegrises) {

        double sumx = 0, sumy = 0;
        double m00 = 0, m01 = 0, m10 = 0;

        for (int i = 0; i < escaladegrises.getWidth(); i++) {
            for (int j = 0; j < escaladegrises.getHeight(); j++) {
                Color c = new Color(escaladegrises.getRGB(i, j));
                m00 += (double) c.getBlue() / 255;
                m10 += (double) c.getBlue() * i / 255;
                m01 += (double) c.getBlue() * j / 255;
            }
        }

        return new Point((int) (m10 / m00), (int) (m01 / m00));
    }

    static BufferedImage only_red(BufferedImage imagen) {

        BufferedImage imageActual = imagen;
        System.out.println(imagen.getType());
        BufferedImage res = new BufferedImage(imageActual.getWidth(), imageActual.getHeight(), imagen.getType());

        for (int i = 0; i < imageActual.getWidth(); i++) {
            for (int j = 0; j < imageActual.getHeight(); j++) {

                Color c = new Color(imageActual.getRGB(i, j));

                c = new Color(c.getRed(), 0, 0);// Color.FromArgb(gris, gris, gris);
                res.setRGB(i, j, c.getRGB());
            }
        }

        return res;
    }

    static BufferedImage segmentation_kmean(BufferedImage img, int numclusters, int MaxNumIterations) {

        SimpleKMedias kmean = new SimpleKMedias();
        kmean.setNumClusters(numclusters);
        kmean.setMaxnumIterations(MaxNumIterations);

        BufferedImage imageActual = img;
        BufferedImage res = new BufferedImage(imageActual.getWidth(), imageActual.getHeight(), img.getType());
        double[][] data = new double[imageActual.getWidth() * imageActual.getHeight()][3];

        int pos = 0;
        for (int i = 0; i < imageActual.getWidth(); i++) {
            for (int j = 0; j < imageActual.getHeight(); j++) {
                Color c = new Color(imageActual.getRGB(i, j));
                data[pos][0] = c.getRed();
                data[pos][1] = c.getGreen();
                data[pos][2] = c.getBlue();
                pos++;
            }
        }

        kmean.build(data);
        double[][] centroids = kmean.getCentroids();
        
        
        for (int i = 0; i < imageActual.getWidth(); i++) {
            for (int j = 0; j < imageActual.getHeight(); j++) {
                Color c = new Color(imageActual.getRGB(i, j));
                int cluster = kmean.getClusterBelong(new double[]{c.getRed(),c.getGreen(),c.getBlue()});
                c = new Color((int)centroids[cluster][0], (int)centroids[cluster][1], (int)centroids[cluster][2]);
                res.setRGB(i, j, c.getRGB());                
            }
        }
        

        return res;

    }

    public interface contrastFunction {

        public double getvalue(float d);
    }

    public static float[][] get_data(BufferedImage abmp) {
        float[][] res = new float[abmp.getWidth()][abmp.getHeight()];
        int _w = abmp.getWidth();
        int _h = abmp.getHeight();

        for (int i = 0; i < _w; i++) {
            for (int j = 0; j < _h; j++) {
                res[i][j] = ((float) (new Color(abmp.getRGB(i, j))).getRed() / (255));
            }
        }

        return res;
    }

    public static BufferedImage bitmap_from_data(float[][] adata) {
        int _w = adata.length;
        int _h = adata[0].length;
        BufferedImage bmp = new BufferedImage(_w, _h, 5);
        for (int i = 0; i < _w; i++) {
            for (int j = 0; j < _h; j++) {
                int val = (int) (adata[i][j] * 255);
                Color c = new Color(val, val, val);
                bmp.setRGB(i, j, c.getRGB());
            }
        }

        return bmp;
    }

    public static float[][] differentiate(float[][] Data, int[][] Filter) {
        int i, j, k, l, Fh, Fw;

        Fw = Filter.length;
        Fh = Filter[0].length;
        float sum = 0;

        int _w = Data.length;
        int _h = Data[0].length;

        float[][] Output = new float[_w][_h];

        for (i = Fw / 2; i <= (_w - Fw / 2) - 1; i++) {
            for (j = Fh / 2; j <= (_h - Fh / 2) - 1; j++) {
                sum = 0;
                for (k = -Fw / 2; k <= Fw / 2; k++) {
                    for (l = -Fh / 2; l <= Fh / 2; l++) {
                        sum = sum + Data[i + k][j + l] * Filter[Fw / 2 + k][Fh / 2 + l];

                    }
                }
                Output[i][j] = sum;

            }

        }
        return Output;

    }

    public static float[][] convolute(float[][] Data, float[][] Filter) {
        int i, j, k, l, Fh, Fw;

        Fw = Filter.length;
        Fh = Filter[0].length;
        float sum = 0;

        int _w = Data.length;
        int _h = Data[0].length;

        float[][] Output = new float[_w][_h];

        for (i = Fw / 2; i <= (_w - Fw / 2) - 1; i++) {
            for (j = Fh / 2; j <= (_h - Fh / 2) - 1; j++) {
                sum = 0;
                for (k = -Fw / 2; k <= Fw / 2; k++) {
                    for (l = -Fh / 2; l <= Fh / 2; l++) {
                        sum = sum + Data[i + k][j + l] * Filter[Fw / 2 + k][Fh / 2 + l];
                    }
                }
                Output[i][j] = sum;

            }

        }
        return Output;

    }

    public static float[][] contract(float[][] adata) {
        float[][] adata2 = adata.clone();
        int _w = adata2.length;
        int _h = adata2[0].length;
        float max = Float.MIN_VALUE;
        float min = Float.MAX_VALUE;
        for (int i = 0; i < _w; i++) {
            for (int j = 0; j < _h; j++) {
                max = Math.max(max, adata2[i][j]);
                min = Math.min(min, adata2[i][j]);
            }
        }

        for (int i = 0; i < _w; i++) {
            for (int j = 0; j < _h; j++) {
                adata2[i][j] = (adata[i][j] - min) / (max - min);
            }
        }

        return adata2;
    }

    public static float[][] hipotenusa(float[][] datax, float[][] datay) {
        float[][] res = new float[datax.length][datax[0].length];
        int _w = res.length;
        int _h = res[0].length;

        for (int i = 0; i < _w; i++) {
            for (int j = 0; j < _h; j++) {
                res[i][j] = (float) (Math.sqrt(datax[i][j] * datax[i][j] + datay[i][j] * datay[i][j]));
                if (res[i][j] > 1) {
                    int g = 8;
                }
            }
        }
        return res;
    }

//    public static BufferedImage[] TransformadaFourier(BufferedImage img) {
//
//        BufferedImage real = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
//        BufferedImage imaginaria = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
//        double phi = 0;
//        for (int i = 0; i < img.getWidth(); i++) {
//            for (int j = 0; j < img.getHeight(); j++) {
//                double suma1 = 0, suma2 = 0;
//                for (int x = 0; x < img.getWidth(); x++) {
//                    for (int y = 0; y < img.getHeight(); y++) {
////                        phi=2*Math.PI*
//                    }
//                }
////                Color c = new Color(img.getRGB(i, j));
////                c = new Color(c.getRed(), 0, 0);
////                res.setRGB(i, j, c.getRGB());
//            }
//        }
//
//        return new BufferedImage[]{real, imaginaria};
//    }

}
