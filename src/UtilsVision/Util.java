/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UtilsVision;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Adiel
 */
 public  class Util
    {
        public static int min(int a, int b)
        {
            return a < b ? a : b;
        }
        public static int max(int a, int b)
        {
            return a > b ? a : b;
        }
        
        
         public static float[][] getData(BufferedImage abmp)
        {
            float[][] res = new float[abmp.getWidth()][abmp.getHeight()];
            int _w = abmp.getWidth();
            int _h = abmp.getHeight();

            for (int i = 0; i < _w; i++)
                for (int j = 0; j < _h; j++)
                {
                    res[i][j] = ((float)(new Color(abmp.getRGB(i, j))).getRed() / (255));
                }

            return res;
        }
                
        public static BufferedImage BitmapFromData(float[][] adata)
        {
            int _w = adata.length;
            int _h = adata[0].length;
            BufferedImage bmp = new BufferedImage(_w, _h,5);
            for (int i = 0; i < _w; i++)
                for (int j = 0; j < _h; j++)
                {
                    int val = (int)(adata[i][j] * 255);
                    Color c = new Color(val, val, val);
                    bmp.setRGB(i, j, c.getRGB());
                }

            return bmp;
        }
        
        
        public static float[][] Differentiate(float[][] Data, int[][] Filter)
        {
            int i, j, k, l, Fh, Fw;

            Fw = Filter.length;
            Fh = Filter[0].length;
            float sum = 0;

            int _w = Data.length;
            int _h = Data[0].length;

            float[][] Output = new float[_w][ _h];

            for (i = Fw / 2; i <= (_w - Fw / 2) - 1; i++)
            {
                for (j = Fh / 2; j <= (_h - Fh / 2) - 1; j++)
                {
                    sum = 0;
                    for (k = -Fw / 2; k <= Fw / 2; k++)
                    {
                        for (l = -Fh / 2; l <= Fh / 2; l++)
                        {
                            sum = sum +  Data[i + k][ j + l] * Filter[Fw / 2 + k][ Fh / 2 + l];


                        }
                    }
                    Output[i][ j] = sum;

                }

            }
            return Output;

        }

        
         public static float[][] Convolute(float[][] Data, float[][] Filter)
        {
            int i, j, k, l, Fh, Fw;

            Fw = Filter.length;
            Fh = Filter[0].length;
            float sum = 0;

            int _w = Data.length;
            int _h = Data[0].length;

            float[][] Output = new float[_w][_h];

            for (i = Fw / 2; i <= (_w - Fw / 2) - 1; i++)
            {
                for (j = Fh / 2; j <= (_h - Fh / 2) - 1; j++)
                {
                    sum = 0;
                    for (k = -Fw / 2; k <= Fw / 2; k++)
                    {
                        for (l = -Fh / 2; l <= Fh / 2; l++)
                        {
                            sum = sum + Data[i + k][ j + l] * Filter[Fw / 2 + k][ Fh / 2 + l];


                        }
                    }
                    Output[i][j] = sum;

                }

            }
            return Output;

        }
         
         public static float[][] Contract(float[][] adata)
        {
            float[][] adata2 =  adata.clone();
            int _w = adata2.length;
            int _h = adata2[0].length;
            float max = Float.MIN_VALUE;
            float min = Float.MAX_VALUE;
            for (int i = 0; i < _w; i++)
                for (int j = 0; j < _h; j++)
                {
                    max = Math.max(max, adata2[i][ j]);
                    min = Math.min(min, adata2[i][ j]);
                }

            for (int i = 0; i < _w; i++)
                for (int j = 0; j < _h; j++)
                {
                    adata2[i][ j] = (adata[i][ j] - min) / (max - min);
                }

            return adata2;
        }
         
         public static float[][] hipotenusa(float[][] datax, float[][] datay)
        {
            float[][] res = new float[datax.length][ datax[0].length];
            int _w = res.length;
            int _h = res[0].length;

            for (int i = 0; i < _w; i++)
                for (int j = 0; j < _h; j++)
                {
                    res[i][j] = (float)(Math.sqrt(datax[i][j] * datax[i][j] + datay[i][j] * datay[i][j]));
                    if (res[i][j] > 1)
                    {
                        int g = 8;
                    }
                }
            return res;
        }
        
        

 /*       public static BufferedImage Convolute(BufferedImage Data, float[][] Filter)
        {
            int i, j, k, l, Fh, Fw;

            Fw = Filter.GetLength(0);
            Fh = Filter.GetLength(1);
            float sumR = 0, sumG = 0, sumB = 0;

            int _w = Data.Width;
            int _h = Data.Height;
            Color pix;

            Bitmap Output = (Bitmap)Data.Clone();

            for (i = Fw / 2; i <= (_w - Fw / 2) - 1; i++)
            {
                for (j = Fh / 2; j <= (_h - Fh / 2) - 1; j++)
                {
                    sumR = sumG = sumB = 0;
                    int cont = 0;
                    for (k = -Fw / 2; k <= Fw / 2; k++)
                    {
                        for (l = -Fh / 2; l <= Fh / 2; l++)
                        {
                            pix = Data.GetPixel(i + k, j + l);
                            sumR = sumR + pix.R * Filter[Fw / 2 + k, Fh / 2 + l];
                            sumG = sumG + pix.G * Filter[Fw / 2 + k, Fh / 2 + l];
                            sumB = sumB + pix.B * Filter[Fw / 2 + k, Fh / 2 + l];
                            cont++;
                        }
                    }
                    Output.SetPixel(i, j, Color.FromArgb((int)sumR, (int)sumG, (int)sumB));

                }

            }
            return Output;

        }

        public static float[,] Convolute(float[,] Data, float[,] Filter)
        {
            int i, j, k, l, Fh, Fw;

            Fw = Filter.GetLength(0);
            Fh = Filter.GetLength(1);
            float sum = 0;

            int _w = Data.GetLength(0);
            int _h = Data.GetLength(1);

            float[,] Output = new float[_w, _h];

            for (i = Fw / 2; i <= (_w - Fw / 2) - 1; i++)
            {
                for (j = Fh / 2; j <= (_h - Fh / 2) - 1; j++)
                {
                    sum = 0;
                    for (k = -Fw / 2; k <= Fw / 2; k++)
                    {
                        for (l = -Fh / 2; l <= Fh / 2; l++)
                        {
                            sum = sum + Data[i + k, j + l] * Filter[Fw / 2 + k, Fh / 2 + l];


                        }
                    }
                    Output[i, j] = sum;

                }

            }
            return Output;

        }*/
/*
        public static float[,] Contract(float[,] adata)
        {
            float[,] adata2 = (float[,])adata.Clone();
            int _w = adata2.GetLength(0);
            int _h = adata2.GetLength(1);
            float max = float.MinValue;
            float min = float.MaxValue;
            for (int i = 0; i < _w; i++)
                for (int j = 0; j < _h; j++)
                {
                    max = Math.Max(max, adata2[i, j]);
                    min = Math.Min(min, adata2[i, j]);
                }

            for (int i = 0; i < _w; i++)
                for (int j = 0; j < _h; j++)
                {
                    adata2[i, j] = (adata[i, j] - min) / (max - min);
                }

            return adata2;
        }
        
        public static float[,] getData(Bitmap abmp)
        {
            float[,] res = new float[abmp.Width, abmp.Height];
            int _w = abmp.Width;
            int _h = abmp.Height;

            for (int i = 0; i < _w; i++)
                for (int j = 0; j < _h; j++)
                {
                    res[i, j] = ((float)abmp.GetPixel(i, j).R / (255));
                }

            return res;
        }
                
        public static Bitmap BitmapFromData(float[,] adata)
        {
            int _w = adata.GetLength(0);
            int _h = adata.GetLength(1);
            Bitmap bmp = new Bitmap(_w, _h);
            for (int i = 0; i < _w; i++)
                for (int j = 0; j < _h; j++)
                {
                    int val = (int)(adata[i, j] * 255);
                    Color c = Color.FromArgb(val, val, val);
                    bmp.SetPixel(i, j, c);
                }

            return bmp;
        }

        public static float[,] hipotenusa(float[,] datax, float[,] datay)
        {
            float[,] res = new float[datax.GetLength(0), datax.GetLength(1)];
            int _w = res.GetLength(0);
            int _h = res.GetLength(1);

            for (int i = 0; i < _w; i++)
                for (int j = 0; j < _h; j++)
                {
                    res[i, j] = (float)(Math.Sqrt(datax[i, j] * datax[i, j] + datay[i, j] * datay[i, j]));
                    if (res[i, j] > 1)
                    {
                        int g = 8;
                    }
                }
            return res;
        }

        public static float[,] umbralizar(float[,] adata, float umbral)
        {
            float[,] adata2 = (float[,])adata.Clone();
            int _w = adata2.GetLength(0);
            int _h = adata2.GetLength(1);
            for (int i = 0; i < _w; i++)
                for (int j = 0; j < _h; j++)
                {
                    adata2[i, j] = adata[i, j] < umbral ? 0 : 1;
                }



            return adata2;
        }*/

    public static float[][] Clamp(float[][] datax, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
