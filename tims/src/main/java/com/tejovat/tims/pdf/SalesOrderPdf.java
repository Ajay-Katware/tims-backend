package com.tejovat.tims.pdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.util.List;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.tejovat.tims.model.CustomerMaster;
import com.tejovat.tims.model.ProductItem;
import com.tejovat.tims.model.ProductMaster;
import com.tejovat.tims.model.SalesItem;
import com.tejovat.tims.model.SalesOrder;

public class SalesOrderPdf{
	public static final String DEST = "E://Tools//sales_order.pdf";
	public static final String IMAGE4 = "E://tejovat//tims-svn//trunk//tims-angular//src//assets//images//logo.png";
	public final PdfFont regular;
	public final PdfFont bold;

	public static void main(String[] args) throws Exception {
		File file = new File(DEST);
		file.getParentFile().mkdirs();
		SalesOrder salesOrder = new SalesOrder();
		new SalesOrderPdf().manipulatePdf(salesOrder, DEST, IMAGE4);
	}

	public SalesOrderPdf() throws IOException {
		this.regular = PdfFontFactory.createFont(FontConstants.HELVETICA);
		this.bold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
	}

	@SuppressWarnings("deprecation")
	public void manipulatePdf(SalesOrder salesOrder, String dest, String img) throws FileNotFoundException, MalformedURLException{
		
		PdfWriter writer = new PdfWriter(dest);

		//Initialize PDF document
		PdfDocument pdf = new PdfDocument(writer);

		// Initialize document
		Document doc = new Document(pdf);

		Table table2 = new Table(new float[]{8, 12, 12});
		table2.setWidthPercent(100);

		Image image = null;
		try {
			image = new Image(ImageDataFactory.create(img));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		image.scaleToFit(120, 200);
		Cell cell2 = new Cell().add(image);
		cell2.setPadding(4);
		cell2.setBorder(Border.NO_BORDER);
		cell2.setBackgroundColor(Color.WHITE);
		table2.addCell(cell2);

		cell2 = new Cell().add(createAddressTable());
		cell2.setBorder(Border.NO_BORDER);
		cell2.setPaddingLeft(2);
		table2.addCell(cell2);

		cell2 = new Cell().add(createSalesorderTable(salesOrder));
		cell2.setBorder(Border.NO_BORDER);
		cell2.setPaddingLeft(2);
		table2.addCell(cell2);

		doc.add(table2);

		doc.add(new Paragraph(""));


		float[] columnWidths = {5, 3, 3};
		Table table = new Table(columnWidths);
		table.setWidthPercent(100);
		// first row
		Cell cell1 = new Cell(1,3).add(new Paragraph("SALES ORDER"));
		cell1.setTextAlignment(TextAlignment.CENTER);
		cell1.setFont(bold);
		cell1.setFontSize(11);
		cell1.setBackgroundColor(Color.LIGHT_GRAY);
		table.addCell(cell1);
		doc.add(table);
		
		doc.add(new Paragraph( ""));
		doc.add(createCustomerTable(salesOrder));
		doc.add(new Paragraph(""));
		doc.add(new Paragraph(""));
		doc.add(createSOInfoTable(salesOrder));
		doc.add(new Paragraph(""));
		doc.add(createItemInfoTable(salesOrder, salesOrder.getSalesItemsCollection()));
		doc.add(new Paragraph("\n\n\n"));
		doc.add(createOtherInfoTable());
		doc.add(createInstructionTable());
		
		System.out.println("DONE");

		doc.close();
	}


	private IBlockElement createSalesorderTable(SalesOrder salesOrder) {
		Cell cell;
		Table innertable = new Table(new float[]{12}); //column width of each columns
		innertable.setWidthPercent(100);

		cell = new Cell().add("SALES ORDER").setFont(bold).setFontSize(14);
		cell.setBorder(Border.NO_BORDER);
		cell.setFontSize(11);
		cell.setTextAlignment(TextAlignment.RIGHT);
		innertable.addCell(cell);

		cell = new Cell().add("Sales Order# "+salesOrder.getSalesorderno());
		cell.setBorder(Border.NO_BORDER);
		cell.setFontSize(9);
		cell.setTextAlignment(TextAlignment.RIGHT);
		innertable.addCell(cell);

		return innertable;
	}

	private Table createAddressTable() {
		Cell cell;
		Table innertable = new Table(new float[]{12}); //column width of each columns
		innertable.setWidthPercent(100);

		cell = new Cell().add("Tejovat Technology").setFont(bold).setFontSize(14);
		cell.setBorder(Border.NO_BORDER);
		cell.setFontSize(10);
		cell.setTextAlignment(TextAlignment.LEFT);
		innertable.addCell(cell);

		cell = new Cell().add("304, 42/1, White Square, Hinjewadi Road \n Wakad Pune - 411057");
		cell.setBorder(Border.NO_BORDER);
		cell.setFontSize(9);
		cell.setTextAlignment(TextAlignment.LEFT);
		innertable.addCell(cell);

		cell = new Cell().add("Phone No: "+"+91 774 500 2244");
		cell.setBorder(Border.NO_BORDER);
		cell.setFontSize(9);
		cell.setTextAlignment(TextAlignment.LEFT);
		innertable.addCell(cell);

		return innertable;
	}


	private Table createInstructionTable() {
		Cell cell;
		Table innertable = new Table(new float[]{12, 4}); //column width of each columns
		innertable.setWidthPercent(100);

		Paragraph p = new Paragraph("Returned goods will not be accepted unless by prior arrangement and accompanied by the original packing slip. Goods returned which were furnished according to order may be accepted by us, less"
				+ "a 25% restocking charge. All gooods listed above are priority of Tejovat Technology Ltd until fully paid for.");
		cell = new Cell().add(p).setFontSize(8);
		cell.setTextAlignment(TextAlignment.LEFT);
		cell.setBorderRight(Border.NO_BORDER);
		cell.setMaxWidth(180);
		cell.setFontSize(9);
		cell.setFont(regular);
		innertable.addCell(cell);

		Paragraph p2 = new Paragraph("Received in good order ______________");
		cell = new Cell().add(p2).setFont(bold);
		cell.setBorderLeft(Border.NO_BORDER);
		cell.setTextAlignment(TextAlignment.CENTER);
		cell.setFontSize(9);
		cell.setHorizontalAlignment(HorizontalAlignment.CENTER);
		innertable.addCell(cell);
		return innertable;
	}
	private Table createOtherInfoTable() {
		Cell cell;
		Table innertable = new Table(new float[]{12, 12}); //column width of each columns
		innertable.setWidthPercent(100);

		cell = new Cell().add("Pcs:			");
		cell.setMaxWidth(180);
		cell.setBorderBottom(Border.NO_BORDER);
		cell.setHeight(25);
		innertable.addCell(cell);

		cell = new Cell().add("Asked us about our monthly specials!").setFont(bold).setFontSize(14);
		cell.setHeight(25);
		cell.setTextAlignment(TextAlignment.CENTER);
		cell.setBorder(Border.NO_BORDER);
		innertable.addCell(cell);
		return innertable;
	}

	private Table createItemInfoTable(SalesOrder salesOrder, List<SalesItem> list) {
		
		Double subtotal = salesOrder.getSubtotal()!=null ? salesOrder.getSubtotal() : 0;
		Double taxValue = salesOrder.getTax()!=null ? salesOrder.getTax() : 0;

		Double taxPercent = ((salesOrder.getTax() * 100) / salesOrder.getSubtotal());
		taxPercent =Double.parseDouble(new DecimalFormat("##.##").format(taxPercent));
		String percentValue = String.valueOf(taxPercent);
		Double total = salesOrder.getTotal()!=null ? salesOrder.getTotal() : 0;
				
		Cell cell;
		Table innertable = new Table(new float[]{2,10,6,6,6,6,6}); ////column width of each columns
		innertable.setWidthPercent(100);
		
		cell = new Cell().add("SR.NO").setFont(bold);
		cell.setTextAlignment(TextAlignment.CENTER);
		cell.setHeight(20);
		cell.setFontSize(11);
		innertable.addCell(cell);

		cell = new Cell().add("ITEM CODE AND NAME").setFont(bold);
		cell.setTextAlignment(TextAlignment.CENTER);
		cell.setHeight(20);
		cell.setFontSize(11);
		innertable.addCell(cell);

		cell = new Cell().add("UNIT").setFont(bold);
		cell.setTextAlignment(TextAlignment.CENTER);
		cell.setHeight(20);
		cell.setFontSize(11);
		innertable.addCell(cell);

		Paragraph p6= new Paragraph("QTY");
		cell = new Cell().add(p6).setFont(bold);
		cell.setTextAlignment(TextAlignment.CENTER);
		cell.setHeight(20);
		cell.setFontSize(11);
		innertable.addCell(cell);
		
		cell = new Cell().add("RATE").setFont(bold);
		cell.setTextAlignment(TextAlignment.CENTER);
		cell.setHeight(20);
		cell.setFontSize(11);
		innertable.addCell(cell);
		
		cell = new Cell().add("DIS(%)").setFont(bold);
		cell.setTextAlignment(TextAlignment.CENTER);
		cell.setHeight(20);
		cell.setFontSize(11);
		innertable.addCell(cell);


		Paragraph p5= new Paragraph("AMOUNT").setFont(bold);
		cell = new Cell().add(p5);
		cell.setTextAlignment(TextAlignment.CENTER);
		cell.setHeight(20);
		cell.setFontSize(11);
		innertable.addCell(cell);

		for(int i=0;i<list.size();i++){
			Integer id = i+1;
			ProductItem productitem = list.get(i).getItemid();
			ProductMaster product = productitem.getProductid();
			String itemCode = product.getProductCode()!=null ? product.getProductCode() : "";
			String itemName = product.getProductName()!=null ? product.getProductName() : "";
			String unit = product.getUnit()!=null ? product.getUnit(): "";
			Integer quantity = list.get(i).getQuantity()!=null? list.get(i).getQuantity() : 0;
			Double rate = product.getSellingPrice()!=null ? product.getSellingPrice(): 0.0;
			Double amount = list.get(i).getAmount()!=null ? list.get(i).getAmount() : 0.0;
			Double discount = list.get(i).getDiscount()!=null ? list.get(i).getDiscount() : 0;
			
			
			cell = new Cell().add(""+id);
			cell.setTextAlignment(TextAlignment.CENTER);
			cell.setFontSize(9);
			innertable.addCell(cell);

			cell = new Cell().add(itemCode+" "+itemName);
			cell.setTextAlignment(TextAlignment.LEFT);
			cell.setFontSize(9);
			innertable.addCell(cell);

			cell = new Cell().add(unit);
			cell.setTextAlignment(TextAlignment.CENTER);
			cell.setFontSize(9);
			innertable.addCell(cell);
			
			cell = new Cell().add(quantity.toString());
			cell.setTextAlignment(TextAlignment.CENTER);
			cell.setFontSize(9);
			innertable.addCell(cell);

			cell = new Cell().add(rate.toString());
			cell.setTextAlignment(TextAlignment.RIGHT);
			cell.setFontSize(9);
			innertable.addCell(cell);
			
			cell = new Cell().add(discount.toString());
			cell.setTextAlignment(TextAlignment.RIGHT);
			cell.setFontSize(9);
			innertable.addCell(cell);
			
			cell = new Cell().add(amount.toString());
			cell.setTextAlignment(TextAlignment.RIGHT);
			cell.setFontSize(9);
			innertable.addCell(cell);
		}
		cell = new Cell().add("");
		cell.setTextAlignment(TextAlignment.LEFT);
		cell.setFontSize(9);
		cell.setBorder(Border.NO_BORDER);
		innertable.addCell(cell);
		
		cell = new Cell().add("");
		cell.setTextAlignment(TextAlignment.LEFT);
		cell.setFontSize(9);
		cell.setBorder(Border.NO_BORDER);
		innertable.addCell(cell);

		cell = new Cell().add("");
		cell.setTextAlignment(TextAlignment.LEFT);
		cell.setFontSize(9);
		cell.setBorder(Border.NO_BORDER);
		innertable.addCell(cell);

		cell = new Cell().add("");
		cell.setTextAlignment(TextAlignment.LEFT);
		cell.setFontSize(9);
		cell.setBorder(Border.NO_BORDER);
		innertable.addCell(cell);

		cell = new Cell().add("");
		cell.setTextAlignment(TextAlignment.LEFT);
		cell.setFontSize(9);
		cell.setBorder(Border.NO_BORDER);
		innertable.addCell(cell);

		cell = new Cell().add("SUBTOTAL");
		cell.setTextAlignment(TextAlignment.LEFT);
		cell.setFontSize(10);
		cell.setFont(bold);
		innertable.addCell(cell);
		
		cell = new Cell().add(subtotal.toString());
		cell.setTextAlignment(TextAlignment.RIGHT);
		cell.setFontSize(9);
		innertable.addCell(cell);
		
		cell = new Cell().add("");
		cell.setBorder(Border.NO_BORDER);
		innertable.addCell(cell);
		
		cell = new Cell().add("");
		cell.setBorder(Border.NO_BORDER);
		innertable.addCell(cell);

		cell = new Cell().add("");
		cell.setBorder(Border.NO_BORDER);
		innertable.addCell(cell);

		cell = new Cell().add("");
		cell.setBorder(Border.NO_BORDER);
		innertable.addCell(cell);

		cell = new Cell().add("");
		cell.setBorder(Border.NO_BORDER);
		innertable.addCell(cell);

		cell = new Cell().add("TAX ("+percentValue+")%");
		cell.setTextAlignment(TextAlignment.LEFT);
		cell.setFontSize(10);
		cell.setFont(bold);
		innertable.addCell(cell);
		
		cell = new Cell().add(taxValue.toString());
		cell.setTextAlignment(TextAlignment.RIGHT);
		cell.setFontSize(9);
		innertable.addCell(cell);
		
		cell = new Cell().add("");
		cell.setBorder(Border.NO_BORDER);
		innertable.addCell(cell);
		
		cell = new Cell().add("");
		cell.setBorder(Border.NO_BORDER);
		innertable.addCell(cell);

		cell = new Cell().add("");
		cell.setBorder(Border.NO_BORDER);
		innertable.addCell(cell);

		cell = new Cell().add("");
		cell.setBorder(Border.NO_BORDER);
		innertable.addCell(cell);

		cell = new Cell().add("");
		cell.setBorder(Border.NO_BORDER);
		innertable.addCell(cell);

		cell = new Cell().add("TOTAL");
		cell.setTextAlignment(TextAlignment.LEFT);
		cell.setFontSize(10);
		cell.setFont(bold);
		innertable.addCell(cell);
		
		cell = new Cell().add(total.toString());
		cell.setTextAlignment(TextAlignment.RIGHT);
		cell.setFontSize(9);
		innertable.addCell(cell);

		return innertable;
	}
	


	private Table createSOInfoTable(SalesOrder salesOrder) {
		Cell cell;
		Table innertable = new Table(new float[]{4, 4, 4, 4}); //column width of each columns
		innertable.setWidthPercent(100);

		cell = new Cell().add("Order Date ").setFont(bold);
		cell.setTextAlignment(TextAlignment.CENTER);
		cell.setFontSize(10);
		innertable.addCell(cell);

		cell = new Cell().add("Shipment Date").setFont(bold);
		cell.setTextAlignment(TextAlignment.CENTER);
		cell.setFontSize(10);
		innertable.addCell(cell);

		cell = new Cell().add("Ship Via").setFont(bold);
		cell.setTextAlignment(TextAlignment.CENTER);
		cell.setFontSize(10);
		innertable.addCell(cell);
		
		cell = new Cell().add("Reference No").setFont(bold);
		cell.setTextAlignment(TextAlignment.CENTER);
		cell.setFontSize(10);
		innertable.addCell(cell);

//		cell = new Cell().add("Entered By: ").setFont(bold);
//		cell.setTextAlignment(TextAlignment.CENTER);
//		innertable.addCell(cell);

		cell = new Cell().add(salesOrder.getOrderdate()!=null ? salesOrder.getOrderdate().toString(): "");
		cell.setTextAlignment(TextAlignment.CENTER);
		cell.setFontSize(9);
		innertable.addCell(cell);

		cell = new Cell().add(salesOrder.getExpecteddate()!=null ? salesOrder.getExpecteddate().toString(): "");
		cell.setTextAlignment(TextAlignment.CENTER);
		cell.setFontSize(9);
		innertable.addCell(cell);

		cell = new Cell().add(salesOrder.getShipvia()!=null ? salesOrder.getShipvia().toString(): "");
		cell.setTextAlignment(TextAlignment.CENTER);
		cell.setFontSize(9);
		innertable.addCell(cell);

		cell = new Cell().add(salesOrder.getReference()!=null ? salesOrder.getReference().toString(): "");
		cell.setTextAlignment(TextAlignment.CENTER);
		cell.setFontSize(9);
		innertable.addCell(cell);

//		cell = new Cell().add("1");
//		cell.setTextAlignment(TextAlignment.CENTER);
//		innertable.addCell(cell);
		return innertable;
	}

	private Table createCustomerTable(SalesOrder salesOrder) {
		CustomerMaster customer = salesOrder.getCustomerid();
		@SuppressWarnings("deprecation")
		Table table = new Table(2);
		table.addCell(new Cell().setBorder(Border.NO_BORDER).setFont(regular).add(createBillToAddressTable(customer)));
		table.addCell(new Cell().setBorder(Border.NO_BORDER).setFont(regular).add(createShipToToAddressTable(customer)));
		return table;
	}

	private IBlockElement createShipToToAddressTable(CustomerMaster customerMaster) {
		String addressline1 = customerMaster.getShipstreetno()!=null ? customerMaster.getShipstreetno(): "";
		String addressline2 = customerMaster.getShipstreetname()!=null ? customerMaster.getShipstreetname(): "";
		String city = customerMaster.getShipcity()!=null ? customerMaster.getShipcity(): "";
		String postalcode = customerMaster.getShippostalcode()!=null ? customerMaster.getShippostalcode(): "";
		String state = customerMaster.getShipstate()!=null ? customerMaster.getShipstate(): "";
		String country = customerMaster.getShipcountry()!=null ? customerMaster.getShipcountry(): "";
		Cell cell;
		Table innertable = new Table(new float[]{12}); //column width of each columns
		innertable.setWidthPercent(100);
		
		cell = new Cell().add("SHIP TO");
		cell.setBorder(Border.NO_BORDER);
		cell.setFontSize(9);
		cell.setFont(bold);
		cell.setTextAlignment(TextAlignment.LEFT);
		innertable.addCell(cell);
		
		String name= customerMaster.getFirstname()+" "+customerMaster.getLastname();
		cell = new Cell().add(name);
		cell.setBorder(Border.NO_BORDER);
		cell.setFontSize(9);
		cell.setFont(bold);
		cell.setTextAlignment(TextAlignment.LEFT);
		innertable.addCell(cell);

		cell = new Cell().add(addressline1+", "+addressline2+"\n"+city+" "+state+" "+postalcode+", "+country);
		cell.setBorder(Border.NO_BORDER);
		cell.setFontSize(9);
		cell.setTextAlignment(TextAlignment.LEFT);
		innertable.addCell(cell);

		return innertable;
	}

	private Table createBillToAddressTable(CustomerMaster customerMaster) {

		String addressline1 = customerMaster.getBillstreetno()!=null ? customerMaster.getBillstreetno(): "";
		String addressline2 = customerMaster.getBillstreetname()!=null ? customerMaster.getBillstreetname(): "";
		String city = customerMaster.getBillcity()!=null ? customerMaster.getBillcity(): "";
		String postalcode = customerMaster.getBillpostalcode()!=null ? customerMaster.getBillpostalcode(): "";
		String state = customerMaster.getBillstate()!=null ? customerMaster.getBillstate(): "";
		String country = customerMaster.getBillcountry()!=null ? customerMaster.getBillcountry(): "";
		Cell cell;
		Table innertable = new Table(new float[]{12}); //column width of each columns
		innertable.setWidthPercent(100);
		
		cell = new Cell().add("BILL TO");
		cell.setBorder(Border.NO_BORDER);
		cell.setFontSize(9);
		cell.setFont(bold);
		cell.setTextAlignment(TextAlignment.LEFT);
		innertable.addCell(cell);
		
		String name= customerMaster.getFirstname()+" "+customerMaster.getLastname();
		cell = new Cell().add(name);
		cell.setBorder(Border.NO_BORDER);
		cell.setFontSize(9);
		cell.setFont(bold);
		cell.setTextAlignment(TextAlignment.LEFT);
		innertable.addCell(cell);

		cell = new Cell().add(addressline1+", "+addressline2+"\n"+city+" "+state+" "+postalcode+", "+country);
		cell.setBorder(Border.NO_BORDER);
		cell.setFontSize(9);
		cell.setTextAlignment(TextAlignment.LEFT);
		innertable.addCell(cell);

		return innertable;
	}

}