import java.awt.*;
import java.text.SimpleDateFormat;

import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 
import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.xy.XYSeriesCollection; 
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class XYLineChart_AWT extends ApplicationFrame 
{
   public XYLineChart_AWT( String applicationTitle, String chartTitle )
   {
      super(applicationTitle);
      JFreeChart xylineChart = ChartFactory.createXYLineChart(
         chartTitle ,
         "Gc最大连通集" ,
         "生成时间t" ,
         createDataset() ,
         PlotOrientation.VERTICAL ,
         true , true , false);
      //改的标题的字体
      TextTitle title = xylineChart.getTitle();
      title.setFont(new Font("微软雅黑", Font.BOLD, 18));


      ChartPanel chartPanel = new ChartPanel( xylineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      final XYPlot plot = xylineChart.getXYPlot( );
      XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
      renderer.setSeriesPaint( 0 , Color.RED );
      renderer.setSeriesPaint( 1 , Color.GREEN );

//      renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
//      renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );

      renderer.setBaseShapesVisible(false);//坐标点的形状是否可见
      renderer.setBaseShapesFilled(false);

      plot.setRenderer( renderer ); 
      setContentPane( chartPanel );

      //解决中文乱码问题
      Font font1 = new Font("微软雅黑",Font.BOLD,18);

      NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
      rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      rangeAxis.setUpperMargin(0.15);
      rangeAxis.setLabelFont(font1);
      rangeAxis.setTickLabelFont(font1);

      NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
      domainAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      domainAxis.setUpperMargin(0.15);
      domainAxis.setLabelFont(font1);
      domainAxis.setTickLabelFont(font1);

   }
   
   private XYDataset createDataset( )
   {
      final XYSeries xian = new XYSeries( "line1" );
      xian.add( 1 , 4 );
      xian.add( 2 , 3 );
      xian.add( 3 , 2 );
      final XYSeries xian2 = new XYSeries( "line2" );
      xian2.add( 1.0 , 4.0 );
      xian2.add( 2.0 , 5.0 );
      xian2.add( 3.0 , 6.0 );

      final XYSeriesCollection dataset = new XYSeriesCollection( );          
      dataset.addSeries( xian );
      dataset.addSeries( xian2 );

      return dataset;
   }

   public static void main( String[ ] args ) 
   {
      XYLineChart_AWT chart = new XYLineChart_AWT("网络生成图", "网络生成图");
      chart.pack( );          
      RefineryUtilities.centerFrameOnScreen( chart );          
      chart.setVisible( true ); 
   }
}

