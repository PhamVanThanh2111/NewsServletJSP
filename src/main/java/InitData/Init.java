package InitData;

import dao.DanhMucDAO;
import dao.TinTucDAO;
import daoimpl.DanhMucDAOImpl;
import daoimpl.TinTucDAOImpl;
import jakarta.persistence.Persistence;
import model.DanhMuc;
import model.TinTuc;

public class Init {
	public static void main(String[] args) {
		DanhMuc dm1 = new DanhMuc("Thể thao", "Người quản lý 1", "Ghi chú 1");
		DanhMuc dm2 = new DanhMuc("An ninh – Quốc phòng", "Người quản lý 2", "Ghi chú 2");
		DanhMuc dm3 = new DanhMuc("Pháp luật – Tư pháp", "Người quản lý 3", "Ghi chú 3");
	
		TinTuc tt1 = new TinTuc("Israel tiếp tục không kích Beirut, Hezbollah cảnh báo cứng rắn", "Sáng sớm 3/10, Isael tiếp tục tấn công các mục tiêu ở thủ đô Beirut của Liban (Lebanon), trong khi phong trào Hezbollah cảnh báo “đây mới chỉ là hiệp đầu tiên”.\r\n", "Liên kết 1", 2);
		TinTuc tt2 = new TinTuc("Hai cựu quan chức cấp cao của cơ quan an ninh Mỹ chỉ trích Trump", "Hai cựu quan chức cấp cao của cơ quan an ninh Mỹ chỉ trích cựu Tổng thống Donald Trump vì đã “đánh đổi” quốc gia để giành lợi ích cá nhân.\r\n", "Liên kết 2", 3);
		TinTuc tt3 = new TinTuc("Miễn phí vé Vòng loại Bảng I - Giải Bóng đá U17 Vô địch châu Á 2025\r\n", "Hơn 1.000 người biểu tình chống vaccine ở Moscow, Nga, sau khi Tổng thống Vladimir Putin ký sắc lệnh bắt buộc vaccine cho mọi người.\r\n", "Liên kết 3", 1);
	
		DanhMucDAO dmDAO = new DanhMucDAOImpl(Persistence.createEntityManagerFactory("tinTucPU"));
		dmDAO.addDanhMuc(dm1);
		dmDAO.addDanhMuc(dm2);
		dmDAO.addDanhMuc(dm3);
		
		TinTucDAO ttDAO = new TinTucDAOImpl(Persistence.createEntityManagerFactory("tinTucPU"));
		ttDAO.addTinTuc(tt1);
		ttDAO.addTinTuc(tt2);
		ttDAO.addTinTuc(tt3);
		
	}
}
