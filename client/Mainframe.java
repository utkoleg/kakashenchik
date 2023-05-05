package client;

import javax.swing.*;
import java.net.Socket;

public class Mainframe extends JFrame {
    private MainPage mainPage;
    private ClientFirstPage clientFirstPage;
    private MenuPage menuPage;
    private BasketPage basketPage;
    private AdminFirstPage adminFirstPage;
    private AddPage addPage;
    private DeletePage deletePage;

    public Mainframe(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700);
        setLayout(null);

        try {
            Socket socket = new Socket("127.0.0.1", 2020);
            ServerConnector sc = new ServerConnector(socket);

            mainPage = new MainPage(this, sc);
            mainPage.setVisible(true);
            add(mainPage);

            clientFirstPage = new ClientFirstPage(this, sc);
            clientFirstPage.setVisible(false);
            add(clientFirstPage);

            menuPage = new MenuPage(this, sc);
            menuPage.setVisible(false);
            add(menuPage);

            basketPage = new BasketPage(this, sc);
            basketPage.setVisible(false);
            add(basketPage);

            adminFirstPage = new AdminFirstPage(this, sc);
            adminFirstPage.setVisible(false);
            add(adminFirstPage);

            addPage = new AddPage(this, sc);
            addPage.setVisible(false);
            add(addPage);

            deletePage = new DeletePage(this, sc);
            deletePage.setVisible(false);
            add(deletePage);
        }catch (Exception e){
            e.printStackTrace();
        }

    }



    public MainPage getMainPage() {
        return mainPage;
    }

    public void setMainPage(MainPage mainPage) {
        this.mainPage = mainPage;
    }

    public ClientFirstPage getClientFirstPage() {
        return clientFirstPage;
    }

    public void setClientFirstPage(ClientFirstPage clientFirstPage) {
        this.clientFirstPage = clientFirstPage;
    }

    public MenuPage getMenuPage() {
        return menuPage;
    }

    public void setMenuPage(MenuPage menuPage) {
        this.menuPage = menuPage;
    }

    public BasketPage getBasketPage() {
        return basketPage;
    }

    public void setBasketPage(BasketPage basketPage) {
        this.basketPage = basketPage;
    }

    public AdminFirstPage getAdminFirstPage() {
        return adminFirstPage;
    }

    public void setAdminFirstPage(AdminFirstPage adminFirstPage) {
        this.adminFirstPage = adminFirstPage;
    }

    public AddPage getAddPage() {
        return addPage;
    }

    public void setAddPage(AddPage addPage) {
        this.addPage = addPage;
    }

    public DeletePage getDeletePage() {
        return deletePage;
    }

    public void setDeletePage(DeletePage deletePage) {
        this.deletePage = deletePage;
    }
}
