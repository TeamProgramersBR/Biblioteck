
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="br.harlock.conn.Conexao"%>
<%@page import="java.sql.Connection"%>
<%int img_id = Integer.parseInt(request.getParameter("IDIMG"));
Connection con = Conexao.getConexao();
ResultSet rs = null;
PreparedStatement pstmt = null;
OutputStream oImage;
try {
pstmt = con.prepareStatement("SELECT Capa FROM titulo WHERE ID_TITU = ?");
pstmt.setInt(1, img_id);
rs = pstmt.executeQuery();
    if(rs.next()) {
        byte barray[] = rs.getBytes(1);
        response.setContentType("image/gif");
        oImage=response.getOutputStream();
        oImage.write(barray);
        oImage.flush();
        oImage.close();
    }
}
catch(Exception ex){
    //ex.printStackTrace();
}finally {
    try{
    if(con!=null)
       con.close();
    }catch(Exception ex){
       // ex.printStackTrace();
    }
}%>