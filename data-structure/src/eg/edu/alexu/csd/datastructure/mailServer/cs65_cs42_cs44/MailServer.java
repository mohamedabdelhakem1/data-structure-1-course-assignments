/**
 *
 */
package eg.edu.alexu.csd.datastructure.mailServer.cs65_cs42_cs44;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
import eg.edu.alexu.csd.datastructure.mailServer.IApp;
import eg.edu.alexu.csd.datastructure.mailServer.IContact;
import eg.edu.alexu.csd.datastructure.mailServer.IFilter;
import eg.edu.alexu.csd.datastructure.mailServer.IFolder;
import eg.edu.alexu.csd.datastructure.mailServer.IMail;
import eg.edu.alexu.csd.datastructure.mailServer.ISort;

/**
 * @author SHIKO
 *
 */
public class MailServer implements IApp{

	/* (non-Javadoc)
	 * @see eg.edu.alexu.csd.datastructure.mailServer.IApp#signin(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean signin(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see eg.edu.alexu.csd.datastructure.mailServer.IApp#signup(eg.edu.alexu.csd.datastructure.mailServer.IContact)
	 */
	@Override
	public boolean signup(IContact contact) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see eg.edu.alexu.csd.datastructure.mailServer.IApp#setViewingOptions(eg.edu.alexu.csd.datastructure.mailServer.IFolder, eg.edu.alexu.csd.datastructure.mailServer.IFilter, eg.edu.alexu.csd.datastructure.mailServer.ISort)
	 */
	@Override
	public void setViewingOptions(IFolder folder, IFilter filter, ISort sort) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see eg.edu.alexu.csd.datastructure.mailServer.IApp#listEmails(int)
	 */
	@Override
	public IMail[] listEmails(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see eg.edu.alexu.csd.datastructure.mailServer.IApp#deleteEmails(eg.edu.alexu.csd.datastructure.linkedList.ILinkedList)
	 */
	@Override
	public void deleteEmails(ILinkedList mails) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see eg.edu.alexu.csd.datastructure.mailServer.IApp#moveEmails(eg.edu.alexu.csd.datastructure.linkedList.ILinkedList, eg.edu.alexu.csd.datastructure.mailServer.IFolder)
	 */
	@Override
	public void moveEmails(ILinkedList mails, IFolder des) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see eg.edu.alexu.csd.datastructure.mailServer.IApp#compose(eg.edu.alexu.csd.datastructure.mailServer.IMail)
	 */
	@Override
	public boolean compose(IMail email) {
		// TODO Auto-generated method stub
		return false;
	}

}
